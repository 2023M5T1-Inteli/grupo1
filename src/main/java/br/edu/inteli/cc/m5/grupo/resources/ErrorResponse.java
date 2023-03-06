package br.edu.inteli.cc.m5.grupo.resources;

public class ErrorResponse {
    
    private int status;
    private ErrorData error;

    public ErrorResponse(int status, String title, String description, String source) {
        this.status = status;
        this.error = new ErrorData(title, description, source);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ErrorData getError() {
        return error;
    }

    public void setError(ErrorData error) {
        this.error = error;
    }

    public static class ErrorData {
        private String title;
        private String description;
        private String source;

        public ErrorData(String title, String description, String source) {
            this.title = title;
            this.description = description;
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
