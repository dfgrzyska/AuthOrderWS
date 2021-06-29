package authz
default allow = false

allow = true{
    input.action == "read"
    input.resource.type == "ordersByCustomerEmail"
    input.resource.email == input.subject.name
}