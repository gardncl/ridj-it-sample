
None selected

Skip to content
Using Gmail with screen readers
Enable desktop notifications for Gmail.
   OK  No thanks

3 of 6,202
Test assignment.
Inbox
x

Alex Nikitin <administrator@ridj-it.com>
Attachments
Nov 12, 2018, 12:27 PM (1 day ago)
to me, Rik, Ari

Hi Clay,

Thanks for expressing your interest in Ridj-it development. After discussing with dev team, we decided to come up with test assignment, so that we can assess your skills.

Please let us know if you have questions. We understand that your time is precious and you may have other priorities in your weekly schedule, but kindly provide approximate time you may need to complete this (I have a week in my mind).

Best regards,
Alex



Attachments area

Clay Gardner
5:38 AM (14 hours ago)
to administrator, rik.ganguly, Antonio

A week sounds reasonable! I'll get it done.


Antonio Iaccarino
9:55 AM (9 hours ago)
to me, administrator, rik.ganguly

Thanks, Clay! Looking forward to it!

Looking forward to it too!Me too!Thanks!

Imagine you work on a web application based around an MVC framework.

There is a page or rather API endpoint that displays (returns) a list of destinations (trips) with some information including Trip ID. These destinations are pulled from a database that supports this application. Assuming destination (trip) has a clickable attribute, when clicked it pulls all available trip information.

To demonstrate your understanding of frameworks and your coding style please detail what steps you would take to implement these features, it is your choice whether to implement a proper MVC view or a REST-like controller responses with JSON. Solution is not required to be in customer shipping state, as it primarily serves a purpose of demonstrating your backend skills.
1) Implement rendering of a List of destination with ability to get full details on particular trip.
2) Implement ability to update an existed trip via REST call.
3) Implement deleting of existed trip.


Sample model (UML):

 Trip
————————
 -id: Long
 -name: String
 -description: String
 -date: Date
 -displayAttributes: Map<String, String>
 -location: Location
 ...

 Location
——————————
 -id: Long
 -name: String
 -address: String
 -city: String
 -state: String
 ...

Required stack:
-Spring;
-Backed by PostgresSQL/MySQL with ORM via Hibernate.

You may extend or add as many fields as you want, as model above has a typical set of properties you would expect, but please use proposed properties for this test assignment.

Your answer is encouraged to have a working code, however if time is a constraint, feel free to fill in with pseudo code to give broad strokes to some of the functionality.

You can include your answer in one text file with headings to denote the different files you might put code in.
ORM_test.txt
Displaying ORM_test.txt.
