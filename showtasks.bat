if not exist runcrud.bat (
   echo.
   echo runcrud.bat not available
   goto fail
   )
call runcrud.bat
if not "%ERRORLEVEL%" == "0" (
   echo.
   echo runcrud.bat terminated with error
   goto fail
   )
timeout /T 10
"%LOCALAPPDATA%\Programs\Opera GX\launcher.exe" --new-window http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo errors found

:end
echo showtasks finished