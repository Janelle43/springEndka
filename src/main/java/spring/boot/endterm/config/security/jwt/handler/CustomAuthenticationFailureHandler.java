package spring.boot.endterm.config.security.jwt.handler;


import spring.boot.endterm.dto.response.FailureResponse;
import spring.boot.endterm.util.BodyWriter;



public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        FailureResponse failureResponse = new FailureResponse(
                HttpStatus.UNAUTHORIZED.value()
                , HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                e.getLocalizedMessage(),
                httpServletRequest.getRequestURI());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        BodyWriter.bodyWriter(httpServletResponse.getWriter(), failureResponse, FailureResponse.class);
    }
}
