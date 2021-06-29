$postParams = [IO.File]::ReadAllText("opa-setup/policies/policy.rego")

Invoke-WebRequest -Uri http://localhost:8181/v1/policies/authz -Method PUT -Body $postParams