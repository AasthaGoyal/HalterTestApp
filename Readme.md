### **`Aim: To create APIs for Halter's Herd Service`**

The application is maven based and allows the user to create APIs regarding Herd management. It allows the user to See all the cow records (I prefilled two records for example purpose), insert a new record and update an existing record by its ID.

Each cow's record has several fields including: 
- Cow Id (Integer - which is automatically generated )
- Cow Number (Integer - User Input)
- Collar Id (String - User Input, I choose string because from example the Collar id would be something like "123-2345-34567")
- Collar status (String - User Input, Mainly 'Active' or 'Broken')

 1. Run: The folder is names as "herd" under src/main/java, you can directly right click on 'Run' and select 'Run Herd application'. On doing so, the application would run on http://localhost:8080. 
 
 ```
 Note: Running on http://localhost:8080 will not display anything, you have to go to /cows/ to process further as followed by in Step 2
 ```

 2. Get all Records: To see all the existing cow records, go to http://localhost:8080/cows. Along with all the other details, a record shows the links to its "self" and the link of the record in the "list". It should display the record in the format:
 
```
{
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
}
 ```
 
3. Create a new record: AsFor instance Cow Id is generated automatically, you only need to pass three values i.e. Cow Number, Collar Id and Collar status. To insert a new record with details as {cowNumber: 123, collarId: 123-5322-54341", status: Active}, the command for the terminal would be:
 
 ```
 curl -X POST localhost:8080/cows -H 'Content-Type:application/json' -d '{"cowNumber":"830", "collarId":"123-5322-54341"", "status":"active"}' 
 ```
 
 You would be able to see the new record has been inserted when you refresh the page at http://localhost:8080/cows. The terminal would also return the record just added with its generated id, which you might need if you want to update the record further.

4. Update an existing record: To update, we would need to pass the id of the record to the link. For instance to change the status of the last record that we added from 'active' to 'broken', the terminal command would be:

```
curl -X PUT localhost:8080/cows/3 -H 'Content-Type:application/json' -d '{"cowNumber":"830", "collarId":"123-5322-54341","status":"broken"}'
```

Refresh the page at http://localhost:8080/cows again to see the updated changes.
