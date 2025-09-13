package com.genomatogenoma.togenoma.document.infrastructure.driven.test.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genomatogenoma.togenoma.document.application.port.DocumentPort;
import com.genomatogenoma.togenoma.document.application.useCases.DocumentUseCases;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.interceptores.DocumentInterceptor;
import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentInterceptorTest {

   private DocumentInterceptor documentInterceptor;

   @BeforeEach
    public void setUp(){
       DocumentPort fakePort = new DocumentPort() {
           @Override
           public void flush() {

           }

           @Override
           public <S extends DocumentEntity> S saveAndFlush(S entity) {
               return null;
           }

           @Override
           public <S extends DocumentEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
               return List.of();
           }

           @Override
           public void deleteAllInBatch(Iterable<DocumentEntity> entities) {

           }

           @Override
           public void deleteAllByIdInBatch(Iterable<Long> longs) {

           }

           @Override
           public void deleteAllInBatch() {

           }

           @Override
           public DocumentEntity getOne(Long aLong) {
               return null;
           }

           @Override
           public DocumentEntity getById(Long aLong) {
               return null;
           }

           @Override
           public DocumentEntity getReferenceById(Long aLong) {
               return null;
           }

           @Override
           public <S extends DocumentEntity> List<S> findAll(Example<S> example) {
               return List.of();
           }

           @Override
           public <S extends DocumentEntity> List<S> findAll(Example<S> example, Sort sort) {
               return List.of();
           }

           @Override
           public <S extends DocumentEntity> List<S> saveAll(Iterable<S> entities) {
               return List.of();
           }

           @Override
           public List<DocumentEntity> findAll() {
               return List.of();
           }

           @Override
           public List<DocumentEntity> findAllById(Iterable<Long> longs) {
               return List.of();
           }

           @Override
           public <S extends DocumentEntity> S save(S entity) {
               return null;
           }

           @Override
           public Optional<DocumentEntity> findById(Long aLong) {
               return Optional.empty();
           }

           @Override
           public boolean existsById(Long aLong) {
               return false;
           }

           @Override
           public long count() {
               return 0;
           }

           @Override
           public void deleteById(Long aLong) {

           }

           @Override
           public void delete(DocumentEntity entity) {

           }

           @Override
           public void deleteAllById(Iterable<? extends Long> longs) {

           }

           @Override
           public void deleteAll(Iterable<? extends DocumentEntity> entities) {

           }

           @Override
           public void deleteAll() {

           }

           @Override
           public List<DocumentEntity> findAll(Sort sort) {
               return List.of();
           }

           @Override
           public Page<DocumentEntity> findAll(Pageable pageable) {
               return null;
           }

           @Override
           public <S extends DocumentEntity> Optional<S> findOne(Example<S> example) {
               return Optional.empty();
           }

           @Override
           public <S extends DocumentEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
               return null;
           }

           @Override
           public <S extends DocumentEntity> long count(Example<S> example) {
               return 0;
           }

           @Override
           public <S extends DocumentEntity> boolean exists(Example<S> example) {
               return false;
           }

           @Override
           public <S extends DocumentEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
               return null;
           }
       };

       StringSanitizer fakeSanitizer = new StringSanitizer();
       ObjectMapper objectMapper = new ObjectMapper();
       DocumentUseCases documentUseCases = new DocumentUseCases(fakePort, fakeSanitizer);
         documentInterceptor = new DocumentInterceptor(objectMapper, documentUseCases);
   }

   @Test
    public void testPreHandle() throws Exception {
       String json = "{\"id\":1,\"title\":\"Test\",\"type\":\"Type\",\"storagePath\":\"/path\",\"ownerCompany\":null}";

       //* Fake HttpServletRequest
       HttpServletRequest request = new HttpServletRequest() {
           @Override
           public String getAuthType() {
               return "";
           }

           @Override
           public Cookie[] getCookies() {
               return new Cookie[0];
           }

           @Override
           public long getDateHeader(String s) {
               return 0;
           }

           @Override
           public String getHeader(String s) {
               return "";
           }

           @Override
           public Enumeration<String> getHeaders(String s) {
               return null;
           }

           @Override
           public Enumeration<String> getHeaderNames() {
               return null;
           }

           @Override
           public int getIntHeader(String s) {
               return 0;
           }

           @Override
           public String getMethod() {
               return "";
           }

           @Override
           public String getPathInfo() {
               return "";
           }

           @Override
           public String getPathTranslated() {
               return "";
           }

           @Override
           public String getContextPath() {
               return "";
           }

           @Override
           public String getQueryString() {
               return "";
           }

           @Override
           public String getRemoteUser() {
               return "";
           }

           @Override
           public boolean isUserInRole(String s) {
               return false;
           }

           @Override
           public Principal getUserPrincipal() {
               return null;
           }

           @Override
           public String getRequestedSessionId() {
               return "";
           }

           @Override
           public String getRequestURI() {
               return "";
           }

           @Override
           public StringBuffer getRequestURL() {
               return null;
           }

           @Override
           public String getServletPath() {
               return "";
           }

           @Override
           public HttpSession getSession(boolean b) {
               return null;
           }

           @Override
           public HttpSession getSession() {
               return null;
           }

           @Override
           public String changeSessionId() {
               return "";
           }

           @Override
           public boolean isRequestedSessionIdValid() {
               return false;
           }

           @Override
           public boolean isRequestedSessionIdFromCookie() {
               return false;
           }

           @Override
           public boolean isRequestedSessionIdFromURL() {
               return false;
           }

           @Override
           public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
               return false;
           }

           @Override
           public void login(String s, String s1) throws ServletException {

           }

           @Override
           public void logout() throws ServletException {

           }

           @Override
           public Collection<Part> getParts() throws IOException, ServletException {
               return List.of();
           }

           @Override
           public Part getPart(String s) throws IOException, ServletException {
               return null;
           }

           @Override
           public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
               return null;
           }

           @Override
           public Object getAttribute(String s) {
               return null;
           }

           @Override
           public Enumeration<String> getAttributeNames() {
               return null;
           }

           @Override
           public String getCharacterEncoding() {
               return "";
           }

           @Override
           public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

           }

           @Override
           public int getContentLength() {
               return 0;
           }

           @Override
           public long getContentLengthLong() {
               return 0;
           }

           @Override
           public String getContentType() {
               return "";
           }

           @Override
           public ServletInputStream getInputStream() throws IOException {
               return null;
           }

           @Override
           public String getParameter(String s) {
               return "";
           }

           @Override
           public Enumeration<String> getParameterNames() {
               return null;
           }

           @Override
           public String[] getParameterValues(String s) {
               return new String[0];
           }

           @Override
           public Map<String, String[]> getParameterMap() {
               return Map.of();
           }

           @Override
           public String getProtocol() {
               return "";
           }

           @Override
           public String getScheme() {
               return "";
           }

           @Override
           public String getServerName() {
               return "";
           }

           @Override
           public int getServerPort() {
               return 0;
           }

           @Override
           public BufferedReader getReader() throws IOException {
               return null;
           }

           @Override
           public String getRemoteAddr() {
               return "";
           }

           @Override
           public String getRemoteHost() {
               return "";
           }

           @Override
           public void setAttribute(String s, Object o) {

           }

           @Override
           public void removeAttribute(String s) {

           }

           @Override
           public Locale getLocale() {
               return null;
           }

           @Override
           public Enumeration<Locale> getLocales() {
               return null;
           }

           @Override
           public boolean isSecure() {
               return false;
           }

           @Override
           public RequestDispatcher getRequestDispatcher(String s) {
               return null;
           }

           @Override
           public int getRemotePort() {
               return 0;
           }

           @Override
           public String getLocalName() {
               return "";
           }

           @Override
           public String getLocalAddr() {
               return "";
           }

           @Override
           public int getLocalPort() {
               return 0;
           }

           @Override
           public ServletContext getServletContext() {
               return null;
           }

           @Override
           public AsyncContext startAsync() throws IllegalStateException {
               return null;
           }

           @Override
           public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
               return null;
           }

           @Override
           public boolean isAsyncStarted() {
               return false;
           }

           @Override
           public boolean isAsyncSupported() {
               return false;
           }

           @Override
           public AsyncContext getAsyncContext() {
               return null;
           }

           @Override
           public DispatcherType getDispatcherType() {
               return null;
           }

           @Override
           public String getRequestId() {
               return "";
           }

           @Override
           public String getProtocolRequestId() {
               return "";
           }

           @Override
           public ServletConnection getServletConnection() {
               return null;
           }
       };

       HttpServletResponse response = new HttpServletResponse() {
           @Override
           public void addCookie(Cookie cookie) {

           }

           @Override
           public boolean containsHeader(String s) {
               return false;
           }

           @Override
           public String encodeURL(String s) {
               return "";
           }

           @Override
           public String encodeRedirectURL(String s) {
               return "";
           }

           public String encodeUrl(String s) {
               return "";
           }

           public String encodeRedirectUrl(String s) {
               return "";
           }

           @Override
           public void sendError(int i, String s) throws IOException {

           }

           @Override
           public void sendError(int i) throws IOException {

           }

           @Override
           public void sendRedirect(String s) throws IOException {

           }

           @Override
           public void setDateHeader(String s, long l) {

           }

           @Override
           public void addDateHeader(String s, long l) {

           }

           @Override
           public void setHeader(String s, String s1) {

           }

           @Override
           public void addHeader(String s, String s1) {

           }

           @Override
           public void setIntHeader(String s, int i) {

           }

           @Override
           public void addIntHeader(String s, int i) {

           }

           @Override
           public void setStatus(int i) {

           }

           public void setStatus(int i, String s) {

           }

           @Override
           public int getStatus() {
               return 0;
           }

           @Override
           public String getHeader(String s) {
               return "";
           }

           @Override
           public Collection<String> getHeaders(String s) {
               return null;
           }

           @Override
           public Collection<String> getHeaderNames() {
               return null;
           }

           @Override
           public String getCharacterEncoding() {
               return "";
           }

           @Override
           public String getContentType() {
               return "";
           }

           @Override
           public ServletOutputStream getOutputStream() throws IOException {
               return null;
           }

           @Override
           public PrintWriter getWriter() throws IOException {
               return null;
           }

           @Override
           public void setCharacterEncoding(String s) {

           }

           @Override
           public void setContentLength(int i) {

           }

           @Override
           public void setContentLengthLong(long l) {

           }

           @Override
           public void setContentType(String s) {

           }

           @Override
           public void setBufferSize(int i) {

           }

           @Override
           public int getBufferSize() {
               return 0;
           }

           @Override
           public void flushBuffer() throws IOException {

           }

           @Override
           public void resetBuffer() {

           }

           @Override
           public boolean isCommitted() {
               return false;
           }

           @Override
           public void reset() {

           }

           @Override
           public void setLocale(Locale locale) {

           }

           @Override
           public Locale getLocale() {
               return null;
           }
       };

       boolean result = documentInterceptor.preHandle(request, response, new Object());
       assertTrue(result);
   }
}
