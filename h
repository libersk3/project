* 81522c3 (HEAD, presentationDay) trying to get this working before the presentation, working on a bit of everything
* d687366 (origin/sprint_3_integration, sprint_3_integration) Fix case on Time entity
* 84c369f Fix case on Team entity
* 23bfc53 Fix case on Account entity
* e7785a4 Fix case on TeamMemberEnroller
* e52c15f Fix case on CreateTeamRequest
* 853ab31 Fix case on AddTeamMember request/response objects
* fea5ffc Fix broken link in new_program_error.jsp
* bf2e9ab Reorganize package structure
* 047fa15 Revert unnecessary changes to classpath and other config files
*   d473eb5 Merge remote-tracking branch 'cassie/sprint_3_integration' into sprint_3_integration
|\  
| * 5f0e641 Fixing classpath once again.
| * 225034b New program forms now take instructor objects as input instead of strings.
| * c3c8d9e **Tests/accounts/all new files are added**
| * 217f671 Students get assigned to account as dependent or primary account holder when created. Students have DOB field. Added validation tests and some other tests
* | 5535192 Remove debug code from EnrollStudentServlet
* |   e083cd7 Merge remote-tracking branch 'charlie/master' into sprint_3_integration
|\ \  
| * | d9562e8 Made it possible for a student to choose the days he/she goes to class
* | | 8b21f4e Add application ID
| |/  
|/|   
* | c7f1973 Revert classpath
* |   311d540 Merge remote-tracking branch 'cassie/master' into sprint_3_integration
|\ \  
| * | c7eda4e StudentAttendance implemented
| * | d685498 student programs
| * | 4ba1f50 student programs page
| * | 6057b48 fixed a bug
| * | 10e66d0 new files
| * | 966f43b Instructor programs view, attendance taking, and attendance view. using strings instead of dates and instructor
|/ /  
* |   2cbffb8 Merge pull request #36 from libersk3/master
|\ \  
| |/  
| * b57fb72 removed comments from Program.java
| * c1e910a fixed adding days to a program
|/  
*   ab0b5ff (tag: sprint_2) Merge branch 'charlie_integration'
|\  
| * 5719bec Correct text of create button on new team form
| * 114cf91 Fix routing of teams page
| * 159fa6b Fix error on teams page
| *   2b5a620 Merge remote-tracking branch 'charlie/master' into charlie_integration
| |\  
|/ /  
| * 5330367 fixed a few bugs
| * d6a9e28 teams are implemented, as are creating programs with specific days
| * e2ca801 trying to create teams and different days per program. bugs are in it, if anybody wants to look them over that would be a appreciated. I'll be back to work on this later tonight. it looks as if all of the changes I made were commited maybe, I'll try to figure it out later.
* |   f716ec9 Merge pull request #34 from fantastic-five/carlos_integration
|\ \  
| * | c6bcc3c Remove duplicate getKey test from StudentTest
| * | 9ae8137 Refactor Instructor tests
| * | 07354f9 Remove unnecessary warning suppression
| * | 32260ea Remove unused imports
| * | 96c472d Fix tests
| * | 359a4de Add CreateInstructorRequest, CreateInstructorResponse and InstructorCreator. All logins and creations of entities are fully functional
| * | 82bb834 Added InstructorsServlet, InstructorFinder, ListInstructorsRequest, ListInstructorsResponse, InstructorsServlet, instructors.jsp, CreateInstructorformServlet, create_instructor_form.jsp, and modified web.xml to map all servlets
| * | ea80a71 Add InstructorAuthenticator, InstructorHomepageServlet, InstructorLoginServlet, instructorlogin.jsp, and InstructorServlet
| * | e2f695e add instructor entity, add instructorTest, add getKey tests
| * | 7c5795b Made Polymorphic Authenticators for Student and Admin (there is no Instructor entity yet).
| * | b662108 Add Student Login Unfinished, two tests in StudentTest, and password attribute with getters and setters in student entity
|/ /  
* |   7ba8594 Merge pull request #28 from fantastic-five/fixes
|\ \  
| * | 8e2e8b5 Tweak layout on enroll student page
| * | 67d4f38 Remove broken link on students page
| * | 18b2638 Fix broken link on program treasury page
| * | 8023f05 Remove broken links on treasury page
| * | e50ac64 Fix Logout button on main layout
| * | 16c6da9 Make title on main layout go to home page
| * | 9010f0b Remove broken back button on main layout
| * | 5a6dd6a Make Student Enroller's List Unenrolled Students more robust
| * | 963b9d4 Update Student Enroller's enroll student method
| * | 36a19ff Refactor validation error messages in JSP
| * | 1999d48 Update student form to handle validation errors
| * | aae26ac Update student creator to handle validation errors
| * | 08f90db Refactor program validation
| * | ea25661 Handle validation errors while creating programs
| * | afdb463 Fix error while attempting to view nonexistant program
|/ /  
* |   99035eb Merge pull request #27 from fantastic-five/sync_environments
|\ \  
| * | 879a1b2 Upgrade App Engine testing utilities to 1.8.8
| * | 9ac1209 Upgrade App Engine SDK to 1.8.8
* | |   1ff8f4f Merge pull request #25 from fantastic-five/more_tests
|\ \ \  
| |/ /  
|/| |   
| * | dd711d9 Test ProgramIncomeViewer
| * | a059291 Test ProgramViewer
| * | ac24c58 Test StudentEnroller
| * | c1a7b0a Test StudentCreator
| * | b2b98f1 Test StudentFinder
| * | cfb6fe0 Test ProgramFinder
| * | bd39082 Test ProgramCreator
| * | b371a4f Test Authenticator
| * | 9e5b0ac Test UserCreator
| * | 46e6973 Add getKey test for the student entity
| * | 00e0a5e Refactor program getKey test
| * | 302c09c Add getKey test to program test
|/ /  
* |   acf8fe5 Merge branch 'enable_sdk_tests'
|\ \  
| |/  
|/|   
| * 7c24351 Update classpath
* |   dce4a61 Merge pull request #23 from fantastic-five/decouple_business_logic
|\ \  
| * | 6fd6771 Extract business logic from servlets
| * | cf67e97 Update packages of servlets and entities
|/ /  
* | 0fc77ef (tag: sprint_1) Make programs treasury servlet use the correct JSP file; fixes #19
* | 0a32556 Extract common code from servlets into abstract base class
|/  
* 74cd08e Ignore `/.settings` file
* 8ccd316 Remove unused `logout.jsp` file
* 8468e3d Add JSP for LoginServlet; fixes #18
* 9b5fe44 Remove unused imports in SingleProgramServlet
* d2cd228 Add JSP for SingleProgramServlet; fixes #17
*   7b1dccd Merge branch 'clean_up'
|\  
| * 7601422 Remove unused warning suppression
| * 11be452 Remove unused imports
| * 544287b Clean up whitespace
|/  
*   87aa5a4 Merge branch 'integration_charlie_master'
|\  
| * 80d960a Remove commented code in servlets
| * 4f1f552 Make Program#getRevenue calculate revenue on the fly
| * 54bb90c Correct `Student#BalanceToString`'s name to use camelCase
| * 97e159c Fix Student#BalanceToString method
| * bf86f3e Update servlets to use JSP files with layout
| * 3818745 presentation
| * 7dffd70 changed the enroll students to jsp
|/  
*   04e2aa4 Merge branch 'clean_up'
|\  
| * 2fa4a61 Change default page to `/homepage` instead of index.html
| * b959951 Remove unnecessary warning suppression
| * 5a3fe23 Remove unused imports
| * 8094992 Update app engine sdk to 1.8.7
|/  
*   2a6015c Merge branch 'integrate_cassie_patch-2'
|\  
| * 67d5259 Fix MIME type of enroll student error page
| * badc31b Fix unowned attribute in program entitity
| * 5034505 Merge duplicate ProgramsServlet into JSP file
| *   2ef286b Merge remote-tracking branch 'cassie/patch-2' into integrate_cassie_patch-2
| |\  
|/ /  
| * 16b6925 Create UserServlet.java
| * 5907a19 Create TreasuryServlet.java
| * 325e217 Create SignUpServlet.java
| * 90e63de Create ProgramTreasuryServlet.java
| * 54646d6 Create LogOutServlet.java
| * eba210d Update LogInServlet.java
| * 997337d Update EnrollStudentServlet.java
| * 13e74db Update HomepageServlet.java
| * 966a1ea Update EnrollStudentServlet.java
| * b61b6c1 Update web.xml
| * bb333b9 Create ProgramsServlet(2).java
| * bb0e3d7 Update Program.java
| * 64c1bd8 Create EnrollStudentServlet.java
| * 2a78fba Create SingleProgramServlet.java
| * 2d32d3c Create HomepageServlet.java
| * 8a8726a Update web.xml
| * c9314f9 Create LogInServlet.java
|/  
*   6f392b1 Merge remote-tracking branch 'carlos/master'
|\  
| * bf1a962 Remove unnecessary jar files from repo
| * 8611eed add StudentTest
| * b5311e0 Finished StudentServlet
| * b499dd4 added students servlet, create students, and improved web.xml readability
* |   863fb5b Merge branch 'programs'
|\ \  
| * | 45c1c38 Remove unused code in tests
| * | c692a91 Add JSP layout to programs pages
| |/  
| * 7872810 Add page for viewing a list of all programs
| * b5ab396 Make programs store all fields
| * 76e4ddd Ignore war/WEB-INF/appengine-generated/
| * f430c0a Refactor ProgramTest with before statement
| * 3c7922c Add JUnit library
| * c5612c6 Ignore war/WEB-INF/classes
| * f4cc5aa Began development of programs feature
|/  
* 45bae9d Initialize repository with web application sample code
