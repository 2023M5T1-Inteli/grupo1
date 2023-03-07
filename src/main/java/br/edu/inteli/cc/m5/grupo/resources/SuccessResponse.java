package br.edu.inteli.cc.m5.grupo.resources;

public class SuccessResponse {
    
    private int status;
    private String title;
    private String description;
    private SuccessData success;

    public SuccessResponse(int status, String title, String description, Object data) {
        this.status = status;
        this.success = new SuccessData(title, description, data);
    }

    public void setSuccess(SuccessData success) {
        this.success = success;
    }

    public static class SuccessData {
        private String title;
        private String description;
        private Object data;

        public SuccessData(String title, String description, Object data) {
            this.title = title;
            this.description = description;
            this.data = data;
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

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}