
# I. Setup

## 1.Get docker image
### a) use my image - default

### b) Build app image:

#### Requirements:
* Java 16
* Docker

Build project -> parent-project -> package

`docker build -t dgrzyska/opa-ws:1.0 .`
## 2. Run docker compose:
`docker compose up`

## 3. Configure OPA server policy:
**Windows:**

`powershell -ExecutionPolicy Bypass -File opa-setup/setup-policy.ps1`

**Linux:**

`sh opa-setup/setup-policy.sh`

# II. Opa policy description

Our policy:
```
package authz
default allow = false

allow = true{
    input.action == "read"
    input.resource.type == "ordersByCustomerEmail"
    input.resource.email == input.subject.name
}
```

By default, our policy doesn't allow accessing data.
The only way to access resource called 'ordersByCustomerEmail' is case when we are authenticated as user which data we would like to fetch.

`input.action` - type of action

`input.resource.type` - resource type

`input.resource.email` - email address of user which data we would like to fetch

`input.subject.name` - name of our authenticated user
# III. Example usage:

### List of users/passwords can be found here:

`package pl.dg.opaws.security.SecurityConfig;`
### Example Postman request:
Request type: POST

URL: http://localhost:8080/graphql

Body type: GraphQL

Authorization: Basic Auth - username/password

```
{
  ordersByCustomerEmail(email:"jan@email.com") {
    id
    customer
    {
        email
        name
    }
  }
}
```