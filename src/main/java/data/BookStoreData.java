package data;

import io.restassured.response.Response;
import java.util.List;

public class BookStoreData {
    private String validEmailUsed;
    private String validPasswordUsed;
    private String accessToken;
    private Response signUpResponse;
    private Response logInResponse;
    private Response addBookResponse;
    private Response editBookResponse;
    private Response getBookDetailsById;
    private List<Response> fetchAllBooks;
    private Response deleteBookResponse;

    // Getters and Setters
    public String getValidEmailUsed() { return validEmailUsed; }
    public void setValidEmailUsed(String validEmailUsed) { this.validEmailUsed = validEmailUsed; }

    public String getValidPasswordUsed() { return validPasswordUsed; }
    public void setValidPasswordUsed(String validPasswordUsed) { this.validPasswordUsed = validPasswordUsed; }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public Response getSignUpResponse() { return signUpResponse; }
    public void setSignUpResponse(Response signUpResponse) { this.signUpResponse = signUpResponse; }

    public Response getLogInResponse() { return logInResponse; }
    public void setLogInResponse(Response logInResponse) { this.logInResponse = logInResponse; }

    public Response getAddBookResponse() { return addBookResponse; }
    public void setAddBookResponse(Response addBookResponse) { this.addBookResponse = addBookResponse; }

    public Response getEditBookResponse() { return editBookResponse; }
    public void setEditBookResponse(Response editBookResponse) { this.editBookResponse = editBookResponse; }

    public Response getGetBookDetailsById() { return getBookDetailsById; }
    public void setGetBookDetailsById(Response getBookDetailsById) { this.getBookDetailsById = getBookDetailsById; }

    public List<Response> getFetchAllBooks() { return fetchAllBooks; }
    public void setFetchAllBooks(List<Response> fetchAllBooks) { this.fetchAllBooks = fetchAllBooks; }

    public Response getDeleteBookResponse() { return deleteBookResponse; }
    public void setDeleteBookResponse(Response deleteBookResponse) { this.deleteBookResponse = deleteBookResponse; }
}
