package javache;

import javache.http.*;
import javache.utility.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private static final String PAGES_PATH = RESOURCES_PATH + "pages\\";
    private static final String ASSETS_PATH = RESOURCES_PATH + "assets\\";
    private static final String NOT_FOUND_PAGE = "not-found.html";

    private static final Map<String, String> CONTENT_TYPES = new HashMap<>() {{
        put("html", "text/html; charset=utf-8");
        put("txt", "text/plain; charset=utf-8");
        put("png", "image/png");
        put("jpg", "image/jpeg");
        put("jpeg", "image/jpeg");
        put("css", "text/css; charset=utf-8");
    }};
    private static final String HTML_EXTENSION_AND_SEPARATOR = ".html";

    private HttpRequest httpRequest;

    private HttpResponse httpResponse;

    private HttpSessionStorage sessionStorage;

    public RequestHandler(HttpSessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public byte[] handleRequest(String requestContent) {
        String debug = "";
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();

        byte[] result = null;

        if (this.httpRequest.getMethod().equals("GET")) {
            result = this.processGetRequest();
        }
        return result;
    }

    private byte[] processGetRequest() {
        String url = this.httpRequest.getRequestUrl();

        if (!this.httpRequest.isResource()) {
            return this.processPageRequest(url);
        }
        return this.processResourceRequest();
    }


    private byte[] processPageRequest(String page) {
        String debug = "";
        if (page.equals("/")) {
            page = "index";
        }
        String pagePath = PAGES_PATH +
                page
                + HTML_EXTENSION_AND_SEPARATOR;

        File file = new File(pagePath);

        byte[] result;

        if (!file.exists() || file.isDirectory()) {
            try {
                result = Files.readAllBytes(Paths.get(PAGES_PATH + NOT_FOUND_PAGE));
                return this.notFound(result);
            } catch (IOException e) {
                return this.internalServerError(WebConstants.INTERNAL_SERVER_ERROR_MESSAGE.getBytes());
            }
        }

        try {
            result = Files.readAllBytes(Paths.get(pagePath));
        } catch (IOException e) {
            return this.internalServerError(WebConstants.INTERNAL_SERVER_ERROR_MESSAGE.getBytes());
        }

        this.httpResponse.addHeader("Content-Type", CONTENT_TYPES.get(Helper.getExtension(file)));

        return this.ok(result);
    }

    private byte[] processResourceRequest() {
        String assetPath = this.httpRequest.getRequestUrl();

        File file = new File(ASSETS_PATH + assetPath);

        if (!file.exists() || file.isDirectory()) {
            return this.notFound(("Asset not found!").getBytes());
        }
        byte[] result;

        try {
            result = Files.readAllBytes(Paths.get(ASSETS_PATH + assetPath));
        } catch (IOException e) {
            return this.internalServerError(WebConstants.INTERNAL_SERVER_ERROR_MESSAGE.getBytes());
        }

        this.httpResponse.addHeader("Content-Type", CONTENT_TYPES.get(Helper.getExtension(file)));
        this.httpResponse.addHeader("Content-Length", result.length + "");
        this.httpResponse.addHeader("Content-Disposition", "inline");

        this.httpResponse.addHeader("Cache-Control", "public,max-age=604800");
        this.httpResponse.addHeader("Accept-Ranges", "bytes");

        return this.ok(result);
    }

    private byte[] ok(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.OK);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] badRequest(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] notFound(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] redirect(byte[] content, String location) {
        this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);
        this.httpResponse.addHeader("Location", location);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] internalServerError(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }
}