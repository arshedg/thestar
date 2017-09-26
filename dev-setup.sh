lsof -i tcp:80| awk '{print $2}'|tail -n +2|xargs kill -9 
npm install http-server
http-server -p 80 &
