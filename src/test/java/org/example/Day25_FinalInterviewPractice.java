package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day25_FinalInterviewPractice {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║    DAY 25: FINAL INTERVIEW PRACTICE & CONFIDENCE BOOST       ║");
        System.out.println("║                                                               ║");
        System.out.println("║  Mock Interviews • Rapid Q&A • Final Tips • YOU'RE READY!    ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n🎉 FINAL INTERVIEW PRACTICE SESSION");
        System.out.println("Let's do this! You're going to CRUSH these interviews!\n");
    }

    // ===== MOCK INTERVIEW 1: Startup Company =====

    @Test(priority = 1, description = "MOCK INTERVIEW 1: Startup QA Role")
    public void testMockInterview1_Startup() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║            MOCK INTERVIEW 1: STARTUP QA ROLE                 ║");
        System.out.println("║              (45 minutes - Fast paced)                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n📍 SCENARIO: Zylex Technologies - Series B Startup");
        System.out.println("   Role: QA Automation Engineer");
        System.out.println("   Team: 3 QA engineers, 12 developers");

        System.out.println("\n🎤 INTERVIEWER: 'Hi! Welcome to Zylex. Tell us about yourself.'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  'Hi! I'm a QA Automation Engineer with comprehensive");
        System.out.println("   expertise in UI, API, and database testing. I recently");
        System.out.println("   completed an intensive 30-day bootcamp where I built");
        System.out.println("   235+ production tests using Selenium, RestAssured, and");
        System.out.println("   JDBC. I'm particularly passionate about CI/CD automation");
        System.out.println("   and have implemented GitHub Actions pipelines. I love");
        System.out.println("   fast-paced environments and am excited to help Zylex");
        System.out.println("   scale quality as you grow.'");

        System.out.println("\n🎤 INTERVIEWER: 'We're moving fast. How do you handle tight deadlines?'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  'In my bootcamp, I delivered 235+ tests in 23 days.");
        System.out.println("   That's consistency under pressure. I prioritize smartly:");
        System.out.println("   - Smoke tests for critical paths (fast validation)");
        System.out.println("   - Automate repetitive tests (saves time)");
        System.out.println("   - Document issues clearly (reduces back-and-forth)");
        System.out.println("   - Use CI/CD for parallel test execution");
        System.out.println("   I communicate blockers early so we can adjust together.'");

        System.out.println("\n🎤 INTERVIEWER: 'Write a quick test for login.'");
        System.out.println("\n✅ YOUR CODE:");
        System.out.println("""
            @Test
            public void quickLoginTest() {
                WebDriver driver = new ChromeDriver();
                driver.get("https://app.zylex.com");
                
                driver.findElement(By.id("email")).sendKeys("user@test.com");
                driver.findElement(By.id("password")).sendKeys("password123");
                driver.findElement(By.xpath("//button[text()='Login']")).click();
                
                new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocatedBy(
                        By.id("dashboard")));
                
                Assert.assertTrue(driver.getCurrentUrl()
                    .contains("dashboard"), "Should redirect to dashboard");
                
                driver.quit();
            }
            """);

        System.out.println("\n🎤 INTERVIEWER: 'Any questions for us?'");
        System.out.println("\n✅ YOUR QUESTIONS:");
        System.out.println("  • What's your current testing coverage?");
        System.out.println("  • How do you prioritize test cases for sprints?");
        System.out.println("  • What's your biggest testing challenge?");
        System.out.println("  • Do you have CI/CD pipelines set up?");
        System.out.println("  • What tools are you using currently?");

        System.out.println("\n✅ INTERVIEW RESULT: PASS ✅");
        System.out.println("   Feedback: Strong technical skills, clear communication,");
        System.out.println("   good understanding of startup needs");
        System.out.println("   Offer Likely: YES");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // ===== MOCK INTERVIEW 2: Enterprise Company =====

    @Test(priority = 2, description = "MOCK INTERVIEW 2: Enterprise QA Role")
    public void testMockInterview2_Enterprise() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║           MOCK INTERVIEW 2: ENTERPRISE QA ROLE              ║");
        System.out.println("║              (60 minutes - More formal)                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n📍 SCENARIO: TechCorp Financial Services");
        System.out.println("   Role: Senior QA Automation Engineer");
        System.out.println("   Team: 15 QA engineers, 80+ developers");

        System.out.println("\n🎤 INTERVIEWER: 'Tell us about your most complex testing project.'");
        System.out.println("\n✅ YOUR ANSWER (STAR METHOD):");
        System.out.println("  S: I built a comprehensive test suite for an e-commerce");
        System.out.println("     platform with UI, API, and database layers.");
        System.out.println("  T: I needed to ensure end-to-end data integrity while");
        System.out.println("     testing 77+ UI workflows and 65+ API endpoints.");
        System.out.println("  A: I:");
        System.out.println("     • Implemented Page Object Model for maintainability");
        System.out.println("     • Created DatabaseHelper for data verification");
        System.out.println("     • Set up GitHub Actions for CI/CD automation");
        System.out.println("     • Established quality gates (95%+ pass rate, <30s runtime)");
        System.out.println("     • Documented everything for team reuse");
        System.out.println("  R: Delivered 235+ tests that run automatically on every");
        System.out.println("     commit. Team adopted my patterns for new projects.");

        System.out.println("\n🎤 INTERVIEWER: 'How do you approach test planning?'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  'I follow a structured approach:");
        System.out.println("   1. Understand requirements thoroughly");
        System.out.println("   2. Identify risk areas (payment, security, data)");
        System.out.println("   3. Categorize tests (unit, integration, E2E, security)");
        System.out.println("   4. Estimate effort and prioritize");
        System.out.println("   5. Set quality metrics (coverage, performance, SLA)");
        System.out.println("   6. Plan for maintainability and scalability");
        System.out.println("   7. Automate 80%, keep 20% manual for exploration'");

        System.out.println("\n🎤 INTERVIEWER: 'Design API tests for a payment system.'");
        System.out.println("\n✅ YOUR DESIGN:");
        System.out.println("  TEST CATEGORIES:");
        System.out.println("  • Happy Path: Process valid payment → 200");
        System.out.println("  • Validation: Invalid amount → 400");
        System.out.println("  • Security: SQL injection attempt → handled safely");
        System.out.println("  • Performance: Response < 500ms for processing");
        System.out.println("  • Concurrency: Handle simultaneous payments");
        System.out.println("  • Idempotency: Retry same request → same result");
        System.out.println("  • Failure Recovery: Rollback on error → clean state");

        System.out.println("\n🎤 INTERVIEWER: 'Where do you see QA going?'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  'QA is evolving towards:");
        System.out.println("   • Continuous testing (not just at the end)");
        System.out.println("   • Shift-left (testing earlier in development)");
        System.out.println("   • AI-powered test generation");
        System.out.println("   • Performance and security as first-class citizens");
        System.out.println("   • Test automation as core development skill");
        System.out.println("   ");
        System.out.println("   I'm excited about these trends and actively learning.'");

        System.out.println("\n✅ INTERVIEW RESULT: PASS ✅");
        System.out.println("   Feedback: Senior-level thinking, strategic approach,");
        System.out.println("   deep technical knowledge");
        System.out.println("   Offer Likely: YES (possible senior role offer)");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // ===== MOCK INTERVIEW 3: Tech Company =====

    @Test(priority = 3, description = "MOCK INTERVIEW 3: Tech Company QA Role")
    public void testMockInterview3_TechCo() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║        MOCK INTERVIEW 3: TECH COMPANY QA ROLE               ║");
        System.out.println("║          (50 minutes - Technical focus)                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n📍 SCENARIO: CloudTech Inc - SaaS Platform");
        System.out.println("   Role: QA Automation Engineer");
        System.out.println("   Focus: Cloud infrastructure, high-scale testing");

        System.out.println("\n🎤 INTERVIEWER: 'How do you handle testing at scale?'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  'I approach scale through:");
        System.out.println("   • Parallelization: Run tests concurrently (GitHub Actions)");
        System.out.println("   • Categorization: Smoke (fast), integration (medium), E2E (slow)");
        System.out.println("   • Mocking: Mock external services for speed");
        System.out.println("   • Database strategies: Use test DBs, not production");
        System.out.println("   • Monitoring: Track test metrics and performance trends");
        System.out.println("   • Smart retry: Retry flaky tests intelligently'");

        System.out.println("\n🎤 INTERVIEWER: 'Tell us about your CI/CD experience.'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  'I've implemented GitHub Actions workflows that:");
        System.out.println("   • Trigger on every commit to main/develop");
        System.out.println("   • Run tests in parallel across 5 threads");
        System.out.println("   • Generate code coverage reports");
        System.out.println("   • Track performance baselines");
        System.out.println("   • Send Slack notifications for failures");
        System.out.println("   • Block merges if pass rate < 95%");
        System.out.println("   ");
        System.out.println("   This ensures code quality before it reaches production.'");

        System.out.println("\n🎤 INTERVIEWER: 'Debug this failing test [shows code]'");
        System.out.println("\n✅ YOUR APPROACH:");
        System.out.println("  1. Look at error: NoSuchElementException");
        System.out.println("  2. Check timing: Element might load late");
        System.out.println("  3. Inspect selector: Locator might have changed");
        System.out.println("  4. Add waits: Use explicit WebDriverWait");
        System.out.println("  5. Use better locator: ID > CSS > XPath");
        System.out.println("  6. Test in isolation: Run just this test");
        System.out.println("  7. Document fix: Prevent future issues");

        System.out.println("\n🎤 INTERVIEWER: 'What metrics do you track?'");
        System.out.println("\n✅ YOUR ANSWER:");
        System.out.println("  • Test coverage: Line and branch coverage %");
        System.out.println("  • Pass rate: Target 95%+ pass rate");
        System.out.println("  • Execution time: Track and optimize");
        System.out.println("  • Defect metrics: Bugs found/escaped");
        System.out.println("  • Test maintenance: Time spent fixing vs writing");
        System.out.println("  • Flakiness: Track and resolve unstable tests");

        System.out.println("\n✅ INTERVIEW RESULT: PASS ✅");
        System.out.println("   Feedback: Strong technical depth, excellent at scale,");
        System.out.println("   metrics-driven mindset");
        System.out.println("   Offer Likely: YES");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // ===== RAPID FIRE Q&A =====

    @Test(priority = 4, description = "RAPID FIRE Q&A Practice")
    public void testRapidFireQA() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║            RAPID FIRE Q&A - 20 QUICK QUESTIONS               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        String[][] qaList = {
                {"Q: What's the difference between assertions and expectations?",
                        "A: Assertions stop test execution on failure. Expectations log but continue."},

                {"Q: How do you handle StaleElementReferenceException?",
                        "A: Use explicit waits, find element fresh after actions, or re-fetch DOM."},

                {"Q: Favorite testing tool and why?",
                        "A: Selenium for UI - mature, supports multiple browsers, large community."},

                {"Q: How do you maintain test data?",
                        "A: Use test DBs, factories, or fixtures. Keep data isolated per test."},

                {"Q: What makes a good test case?",
                        "A: Independent, clear, fast, reliable, maintainable, and focused."},

                {"Q: How do you prioritize automation?",
                        "A: High priority: critical paths, repetitive, deterministic tests."},

                {"Q: Explain test-driven development (TDD)",
                        "A: Write tests first, then code. Ensures design and quality."},

                {"Q: How do you handle dynamic content?",
                        "A: Use waits, data attributes, relative XPath, or flexible selectors."},

                {"Q: What's regression testing?",
                        "A: Testing existing functionality after changes to ensure no breakage."},

                {"Q: How do you measure test success?",
                        "A: Coverage %, pass rate, bugs found, time to run, maintenance effort."},

                {"Q: Biggest challenge in automation?",
                        "A: Maintaining tests as app changes. Solution: POM and stable selectors."},

                {"Q: How do you handle API authentication in tests?",
                        "A: Use test tokens, mock servers, or environment variables. Never hardcode."},

                {"Q: What's performance testing?",
                        "A: Testing speed, scalability, under load. Check SLAs like <500ms."},

                {"Q: How do you deal with network latency?",
                        "A: Use appropriate timeouts, retry logic, mock external APIs."},

                {"Q: Explain the testing pyramid",
                        "A: Lot of unit tests, fewer integration, even fewer E2E. Fastest to slowest."},

                {"Q: How do you test third-party integrations?",
                        "A: Mock them in tests, test contracts, verify error handling."},

                {"Q: What's CI/CD to you?",
                        "A: Automate testing and deployment. Catch bugs early, fast feedback."},

                {"Q: How do you prevent test interdependence?",
                        "A: Make each test independent, use isolation, don't rely on execution order."},

                {"Q: Explain exploratory testing",
                        "A: Simultaneous learning, test design, and execution. Find unexpected bugs."},

                {"Q: Your biggest strength in QA?",
                        "A: Problem-solving. I debug systematically and communicate clearly."}
        };

        for (int i = 0; i < qaList.length; i++) {
            System.out.println("\n" + (i+1) + ". " + qaList[i][0]);
            System.out.println("   " + qaList[i][1]);
        }

        System.out.println("\n✅ ALL 20 QUESTIONS ANSWERED!");
    }

    // ===== INTERVIEW DAY TIPS =====

    @Test(priority = 5, description = "Interview Day Tips & Final Confidence")
    public void testInterviewDayTips() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║            INTERVIEW DAY TIPS & FINAL CONFIDENCE              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n✅ DAY BEFORE INTERVIEW:");
        System.out.println("  • Get good sleep (8 hours)");
        System.out.println("  • Review your projects and portfolio");
        System.out.println("  • Write down key achievements");
        System.out.println("  • Practice your elevator pitch");
        System.out.println("  • Prepare questions for them");
        System.out.println("  • Check route/connection (if remote)");
        System.out.println("  • Lay out professional clothes");

        System.out.println("\n✅ MORNING OF INTERVIEW:");
        System.out.println("  • Eat a good breakfast");
        System.out.println("  • Exercise or walk (reduces anxiety)");
        System.out.println("  • Dress professionally");
        System.out.println("  • Arrive 10-15 minutes early");
        System.out.println("  • Bring copies of resume");
        System.out.println("  • Phone fully charged");
        System.out.println("  • Clear workspace (if virtual)");

        System.out.println("\n✅ DURING INTERVIEW:");
        System.out.println("  • Greet with firm handshake and smile");
        System.out.println("  • Make eye contact (90% of time)");
        System.out.println("  • Speak clearly and confidently");
        System.out.println("  • Pause before answering (shows thoughtfulness)");
        System.out.println("  • Use examples from your projects");
        System.out.println("  • Listen carefully to questions");
        System.out.println("  • Show enthusiasm and passion");
        System.out.println("  • Mention your GitHub portfolio");
        System.out.println("  • Use STAR method for stories");

        System.out.println("\n✅ ANSWERING TECHNICAL QUESTIONS:");
        System.out.println("  • Think before speaking (5-10 seconds OK)");
        System.out.println("  • Explain your reasoning");
        System.out.println("  • Show code examples if applicable");
        System.out.println("  • Discuss trade-offs");
        System.out.println("  • If stuck: 'I don't know but would approach it by...'");

        System.out.println("\n✅ YOUR QUESTIONS FOR THEM:");
        System.out.println("  • What does success look like in this role?");
        System.out.println("  • What's your current testing strategy?");
        System.out.println("  • How do you prioritize quality vs speed?");
        System.out.println("  • What tools and frameworks do you use?");
        System.out.println("  • How does QA collaborate with dev?");
        System.out.println("  • What's your biggest testing challenge?");
        System.out.println("  • What's the team like?");

        System.out.println("\n✅ AFTER INTERVIEW:");
        System.out.println("  • Send thank you email within 24 hours");
        System.out.println("  • Mention specific topics discussed");
        System.out.println("  • Reiterate interest in role");
        System.out.println("  • Don't follow up too aggressively");
        System.out.println("  • Be patient for response");

        System.out.println("\n🎯 CONFIDENCE AFFIRMATIONS:");
        System.out.println("  ✓ 'I have built 235+ production tests'");
        System.out.println("  ✓ 'I understand full-stack testing'");
        System.out.println("  ✓ 'I solve problems systematically'");
        System.out.println("  ✓ 'I communicate clearly'");
        System.out.println("  ✓ 'I'm passionate about quality'");
        System.out.println("  ✓ 'I deserve this opportunity'");
        System.out.println("  ✓ 'I will crush this interview'");

        System.out.println("\n💪 YOU ARE READY!");
    }

    // ===== FINAL MESSAGE =====

    @Test(priority = 6, description = "Final Confidence Boost & Next Steps")
    public void testFinalConfidenceBoost() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  DAY 25 COMPLETE!                            ║");
        System.out.println("║              YOU'RE INTERVIEW-READY & CONFIDENT!             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n🎉 WHAT YOU'VE ACCOMPLISHED:");
        System.out.println("  ✅ 235+ Production Tests Written");
        System.out.println("  ✅ Full-Stack Testing Expertise");
        System.out.println("  ✅ Professional GitHub Portfolio");
        System.out.println("  ✅ CI/CD Pipeline Mastery");
        System.out.println("  ✅ 50+ Interview Questions Answered");
        System.out.println("  ✅ 3 Full Mock Interviews Completed");
        System.out.println("  ✅ 20 Rapid-Fire Q&A Practiced");
        System.out.println("  ✅ Interview Strategy Mastered");

        System.out.println("\n📊 YOUR INTERVIEW READINESS:");
        System.out.println("  Technical Knowledge: 100% ✅");
        System.out.println("  Communication Skills: 95% ✅");
        System.out.println("  Confidence Level: 98% ✅");
        System.out.println("  Preparation: 99% ✅");
        System.out.println("  OVERALL READINESS: 98.25% ✅✅✅");

        System.out.println("\n🎯 WHAT TO SAY IN INTERVIEWS:");
        System.out.println("  'In 25 days, I completed an intensive bootcamp and built");
        System.out.println("   235+ production tests across UI, API, and database layers.");
        System.out.println("   I implemented Page Object Model, CI/CD pipelines, and");
        System.out.println("   professional testing frameworks. My GitHub portfolio shows");
        System.out.println("   consistent growth and quality code. I'm excited to bring");
        System.out.println("   this expertise to your team and make a real impact on quality.'");

        System.out.println("\n🚀 NEXT 5 DAYS:");
        System.out.println("  Day 26-28: Polish Resume, LinkedIn, Cover Letter");
        System.out.println("  Day 29-30: Launch Job Search & Start Applying");

        System.out.println("\n💼 YOU'RE OFFICIALLY JOB-READY!");
        System.out.println("   Start applying to companies you love!");

        System.out.println("\n🎤 GO CRUSH THOSE INTERVIEWS! 🎤");

        Assert.assertTrue(true, "You're ready!");
    }
}