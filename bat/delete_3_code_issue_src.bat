REM REMOVE 3 FILES WHICH WILL BLOCK CTRL+B PROCESS

@ECHO OFF

ECHO ERASING 3 FILES...

DEL /F /S /Q /A "D:\hello\abc\src_test\com\vjia\document\DocumentLogicTest.java"

DEL /F /S /Q /A "D:\hello\src_test\com\vjia\part\PartTest.java"

DEL /F /S /Q /A "D:\hello\src_test\com\vjia\util\FormatHelperTest.java"

PAUSE