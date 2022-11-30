# JPA

Tables:
1) login:

    id
    
    password
    
    active/inactive
    
2) userDetails:

    id
    
    loginId
    
    name
    
    add
    
    contactno
    
    type: admin/user
    
3) permission:

    id
    
    userid
    
    permissionlevel: 1,2,3,4,5
    


Write entity class for them and find. insert delete, using JPA methods

Write entity class for them and find. insert delete, using queries

try to create one to one mapping in login and userDetails table
get data from both tables using JPA only
