### **`Aim: To create APIs for Halter's Herd Service`**

The application is maven based and allows the user to create APIs regarding Herd management. It allows the user to See all the cow records (I prefilled two records for example purpose), insert a new record and update an existing record by its ID.

Each cow's record has several fields including: 
> Cow Id (which is automatically generated )
> 
> Cow Number 
> 
> Collar Id
> 
> Collar status (Mainly 'Active' or 'Broken')
>
 1. Run: The folder is names as "herd" under src/main/java, you can directly right click on 'Run' and select 'Run Herd application'. On doing so, the application would run on http://localhost:8080

 2. Get all Records: To see all the existing cow records, go to http://localhost:8080/cows, it should display the record in the format:
 
`{
 id: 1,
 cowNumber: 123,
 collarId: 44321,
 status: "Active",
 _links: {
 self: {
 href: "http://localhost:8080/cows/1"
 },
 cows: {
 href: "http://localhost:8080/cows"
 }
 }
 },`
 
 3. Create a new record: For instance to insert a new record with details as {cowNumber: 123, collarId: 12353221, status: Active}, the command for the terminal would be:

`curl -X POST localhost:8080/cows -H 'Content-Type:application/json' -d '{"cowNumber":"830", "collarId":"12353221", "status":"active"}' `
 
 You would be able to see the new record has been inserted when you refresh the page at http://localhost:8080/cows

 4. Update an existing record: For instance to change the status of the last record that we added from 'active' to 'broken', the terminal command would be:

`
curl -X PUT localhost:8080/cows/3 -H 'Content-Type:application/json' -d '{"cowNumber":"830", "collarId":"12353221","status":"broken"}'`