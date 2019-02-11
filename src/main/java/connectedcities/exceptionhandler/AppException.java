package connectedcities.exceptionhandler;

public class AppException {
    public static class InputFileNotFoundExecution extends BaseException
    {
        private static final long serialVersionUID = 1555714415375055307L;
        public InputFileNotFoundExecution(String msg) {
            super(msg);
        }
    }
}
