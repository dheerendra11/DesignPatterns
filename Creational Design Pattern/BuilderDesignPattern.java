import java.util.HashMap;
import java.util.Map;

class HTTPRequest{
    // Required
    private final String url;

    // Optional
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;

    private HTTPRequest(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    // getter

    public String toString() {
        return "HttpRequest{" +
               "url='" + url + '\'' +
               ", method='" + method + '\'' +
               ", headers=" + headers +
               ", queryParams=" + queryParams +
               ", body='" + body + '\'' +
               ", timeout=" + timeout +
               '}';
    }


    static class Builder {
        private final String url;

        // Optional
        private String method = "";
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private String body = "";
        private int timeout = 3000;

        public Builder(String url){
            this.url = url;
        }

        public Builder method(String method){
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value){
            this.headers.put(key, value);
            return this;
        }

        public Builder addQueryParameter(String key, String value){
            this.queryParams.put(key, value); 
            return this;
        }

        public Builder body(String body){
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout){
            this.timeout = timeout;
            return this;
        }

        public HTTPRequest build(){
            return new HTTPRequest(this);
        }
    }
}

class Main{
    public static void main(String[] args){
        HTTPRequest request = new HTTPRequest.Builder("url").method("Get").addHeader("Key1", "val1").body("User id").build();
        System.out.println(request);
    }
}

