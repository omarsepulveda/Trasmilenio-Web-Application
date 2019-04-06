public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        String origin = req.getHeader("Origin");

        boolean options = "OPTIONS".equals(req.getMethod());
        if (options) {
            if (origin == null) return;
            resp.addHeader("Access-Control-Allow-Headers", "origin, authorization, accept, content-type, x-requested-with");
            resp.addHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS");
            resp.addHeader("Access-Control-Max-Age", "3600");
        }

        resp.addHeader("Access-Control-Allow-Origin", origin == null ? "*" : origin);
        resp.addHeader("Access-Control-Allow-Credentials", "true");

        if (!options) chain.doFilter(req, resp);
    }
}
// @CompileStatic
// class CustomCorsFilter extends org.springframework.web.filter.CorsFilter {
 
//     CustomCorsFilter() {
//         super(configurationSource())
//     }
 
//     private static UrlBasedCorsConfigurationSource configurationSource() {
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowCredentials(true)
//         config.addAllowedOrigin('http://localhost:4200')
//         ['origin', 'authorization', 'accept', 'content-type', 'x-requested-with'].each { header ->
//             config.addAllowedHeader(header)
//         }
//         ['GET', 'HEAD', 'POST', 'PUT', 'DELETE', 'OPTIONS'].each { method ->
//             config.addAllowedMethod(method)
//         }
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration('/**', config)
//         return source
//     }
 
// }