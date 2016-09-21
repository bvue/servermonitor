
### User Sign up

1. User chooses Register button on screen 
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User signs in
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Server Monitor

1. Page sends a request to view the servers.
1. Servlet uses the serverMonitor dao to select reports
1. Dao performs select and creates report objects from results.
1. Dao returns list of report matching criteria to servlet.
1. Servlet sends list back to jsp.
1. jsp displays the server list.
1. Consider paging results so page does not get super long and too much data 
is sent.



