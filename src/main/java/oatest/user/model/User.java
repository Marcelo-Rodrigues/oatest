package oatest.user.model;

public class User {
  //@Id
  private String _id;
  private String apiKey;
  private String role;
  
  public User() {}
  
  public User(String _id, String apiKey, String role) {
    super();
    this._id = _id;
    this.apiKey = apiKey;
    this.role = role;
  }

  public String get_id() {
    return _id; 
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  //@JsonProperty(value = "api-key")
  public String getApiKey() {
    return apiKey;
  }
  
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }
  
  //@JsonProperty(value = "role")
  public String getRole() {
    return role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User [_id=" + _id + ", apiKey=" + apiKey + ", role=" + role
        + "]";
  }
}
