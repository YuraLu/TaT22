Communication between Jenkins and Github
We need to communication between our Jenkins Server and Github Repository. 
Since we are working on localhost, we should tunnel localhost to make it available for Github. We will use ngrok for this purpose.

Download ngrok matches with your system here https://ngrok.com/
Unzip it. 
From the folder where ngrok unzipped

type:

./ngrok http 8080

ngrok terminal will pop up, copy the href next to the Forwarding

Forwarding http://21db9b29.ngrok.io -> localhost:8080

It is http://21db9b29.ngrok.io in my terminal. Now it is our localhost:8080 which is the port tomcat runs. 
When someone clicks on this link while we keep ngrok terminal running, they can get our localhost like getting a webpage!

Go to your Github repository. Click on Settings -> Webhooks & services. 
For example https://github.com/[user name]/[repository]/settings/hooks it is.

Click on Add service dropdown. Select Jenkins (Git plugin).
Paste your ngrok link here with some addition. 
Our ngrok link hrefs to tomcat, while we want to go jenkins, add "/jenkins" and "/github-webhook/" for the webhook part. 
Final link is http://21db9b29.ngrok.io/jenkins/github-webhook/

Click "Add service" and "Test service".