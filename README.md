# Link Shortener

A simple link shortening app I made that combines a few different principles found across the web.

This repo contains the API layer to retreive and create shortened URLs. It can be called directly and will create
a short URL/retrieve URLs.

I am periodically hosting it on a elastic beanstalk found at http://short.mitanderson.com/

The only pre-requisite is that you need an amazon account with a dynamoDB set up that matches the name 
of the LinkEntity table (currently "links"). This could be swapped out for a h2 / SQL etc. db locally.

There is also a front-end repo found here https://github.com/mitchanderso/link-shorten-frontend