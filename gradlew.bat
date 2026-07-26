@if "%DEBUG%"=="" @echo off
@rem Gradle bootstrap for Windows
set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%
set GRADLE_WRAPPER_JAR=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
if not exist "%GRADLE_WRAPPER_JAR%" (
    echo Downloading Gradle wrapper...
    powershell -Command "Invoke-WebRequest -Uri 'https://github.com/gradle/gradle/raw/v8.7.0/gradle/wrapper/gradle-wrapper.jar' -OutFile '%GRADLE_WRAPPER_JAR%'"
)
"%GRADLE_WRAPPER_JAR%" %*
