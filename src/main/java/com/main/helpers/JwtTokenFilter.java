package com.main.helpers;

import com.main.contract.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.List.of;
import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.isEmpty;

    @Component
    public class JwtTokenFilter extends OncePerRequestFilter {

        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        private IAuthService userRepo;

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain) throws ServletException, IOException {

            final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (isEmpty(header) || !header.startsWith("Bearer ")) {
                chain.doFilter(request, response);
                return;
            }

            final String token = header.split(" ")[1].trim();
            if (!jwtTokenUtil.validate(token)) {
                chain.doFilter(request, response);
                return;
            }

            UserDetails userDetails = userRepo
                    .getUserByUsername(jwtTokenUtil.getUsername(token))
                    .orElse(null);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null,
                    ofNullable(userDetails).map(UserDetails::getAuthorities).orElse(of())
            );

            authentication
                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }
    }


