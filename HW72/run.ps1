if (-not (Test-Path -Path ./dist)) {
    New-Item -ItemType Directory -Path ./dist
}

javac -encoding utf-8 -d ./dist Cal.java
java -cp ./dist Cal
pause