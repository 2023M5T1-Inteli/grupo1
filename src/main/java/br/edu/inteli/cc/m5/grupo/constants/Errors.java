package br.edu.inteli.cc.m5.grupo.constants;

public class Errors {
    
    public static class SERVER {
        
        public static class INTERNAL_SERVER_ERROR {
            
            public static final String TITLE = "Internal Server Error";
            public static final String DESCRIPTION = "Unexpected error occurred on server";
            public static final int STATUS = 500;
            
        }
        
    }
    
    public static class COORDINATE {
        
        public static class NOT_FOUND {
            
            public static final String TITLE = "Coordinate Not Found";
            public static final String DESCRIPTION = "The requested coordinate was not found";
            public static final int STATUS = 404;
            
        }
        
        public static class INVALID_DATA {
            
            public static final String TITLE = "Invalid Coordinate Data";
            public static final String DESCRIPTION = "The provided coordinate data is invalid";
            public static final int STATUS = 422;
            
        }
        
    }
    
    public static class GRAPH {
        
        public static class NOT_FOUND {
            
            public static final String TITLE = "Graph Not Found";
            public static final String DESCRIPTION = "The requested graph was not found";
            public static final int STATUS = 404;
            
        }
        
        public static class INVALID_DATA {
            
            public static final String TITLE = "Invalid Graph Data";
            public static final String DESCRIPTION = "The provided graph data is invalid";
            public static final int STATUS = 422;
            
        }
        
    }
    
    public static class PATH {
        
        public static class NOT_FOUND {
            
            public static final String TITLE = "Path Not Found";
            public static final String DESCRIPTION = "The requested path was not found";
            public static final int STATUS = 404;
            
        }
        
        public static class INVALID_DATA {
            
            public static final String TITLE = "Invalid Path Data";
            public static final String DESCRIPTION = "The provided path data is invalid";
            public static final int STATUS = 422;
            
        }
        
    }
}