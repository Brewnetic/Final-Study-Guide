/**
 * FinalExamStudyGuide.java
 *
 * ╔════════════════════════════════════════════════════════════════╗
 * ║                 🎮 THE JAVA QUEST: FINAL TRIALS 🎮             ║
 * ║            A Gamified Study Adventure for CS 122 Final         ║
 * ╚════════════════════════════════════════════════════════════════╝
 *
 * You are a Java Developer who has completed the Midterm Gauntlet!
 * Now you face the FINAL TRIALS—legendary challenges that will test
 * your mastery of Collections, Exception Handling, File I/O, Recursion,
 * and Testing. Each challenge rewards XP and unlocks wisdom.
 *
 * ===================================================================================
 * HOW TO BECOME A JAVA MASTER:
 *
 * PHASE 1: QUEST DEVELOPMENT
 * - Complete each `// TODO:` section by filling in the blanks with Java code.
 * - Don't just copy-paste—understand what each line does. These are teaching moments!
 * - Each TODO tests a specific concept from Lectures 10-17.
 *
 * PHASE 2: THE TRIALS
 * - Once all TODOs are complete, compile and run this file.
 * - Answer trivia questions to earn XP and level up.
 * - Defeat the legendary bosses to prove your mastery.
 * - Unlock secrets and achievements along the way.
 *
 * May your code compile cleanly and your logic be sound. Good luck, developer!
 * ===================================================================================
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinalExamStudyGuide {

    // Game state variables
    private static int totalXP = 0;
    private static int level = 1;
    private static final int MAX_POSSIBLE_XP = 30;
    private static boolean isDarkModeEnabled = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWelcome();
        System.out.print("\nEnter your developer name: ");
        String playerName = scanner.nextLine();

        displayGameStart(playerName);

        boolean isQuestActive = true;
        while (isQuestActive) {
            displayQuestMenu();
            System.out.print("\n▶ Choose your quest (1-6): ");
            
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("❌ Invalid input! Please enter a number 1-6.");
                continue;
            }

            switch (choice) {
                case 1:
                    questOneCollectionsArtifacts(scanner);
                    break;
                case 2:
                    questTwoExceptionDragon(scanner);
                    break;
                case 3:
                    questThreeFileVault(scanner);
                    break;
                case 4:
                    questFourRecursionMaze(scanner);
                    break;
                case 5:
                    questFiveBossBattle(scanner);
                    break;
                case 6:
                    isQuestActive = false;
                    break;
                default:
                    System.out.println("❌ Invalid quest number. Choose 1-6.");
            }

            if (isQuestActive && choice >= 1 && choice <= 5) {
                updateLevel();
                System.out.println("\n" + "═".repeat(60));
                System.out.printf("📊 PROGRESS: %d XP | LEVEL %d | %d/%d XP to mastery\n", 
                    totalXP, level, totalXP, MAX_POSSIBLE_XP);
                System.out.println("═".repeat(60));
            }
        }

        displayGameEnd(playerName);
        scanner.close();
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // QUEST 1: COLLECTIONS ARTIFACTS - Mastering the Collections Framework
    // ═══════════════════════════════════════════════════════════════════════════════
    private static void questOneCollectionsArtifacts(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  QUEST 1: THE COLLECTIONS ARTIFACTS                        ║");
        System.out.println("║  Gather the three legendary artifacts of the Collections  ║");
        System.out.println("║  Framework: ArrayList, HashSet, and HashMap               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        // ARTIFACT 1: ARRAYLIST
        System.out.println("\n🏺 ARTIFACT 1: ArrayList - The Expandable Scroll");
        System.out.println("   A dynamic, resizable list that grows as you add items.");
        System.out.println("   Unlike arrays, you don't need to know the size in advance!");

        System.out.println("\nQuestions about ArrayList:");
        System.out.print("Q1: Which method adds an element to the END of an ArrayList? ");
        String q1 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: "add" - This is the method signature: list.add(object)
        if (q1.contains("add")) {
            System.out.println("   ✅ CORRECT! .add(object) appends to the end in O(1) amortized time.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. The method is .add(object)");
        }

        System.out.print("Q2: What does ArrayList provide that regular arrays don't? ");
        String q2 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: Contains "dynamic", "resize", or "flexible"
        if (q2.contains("dynamic") || q2.contains("resize") || q2.contains("flexible") || q2.contains("grow")) {
            System.out.println("   ✅ CORRECT! ArrayList DYNAMICALLY resizes. Arrays are fixed-size.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. ArrayList provides DYNAMIC SIZING.");
        }

        // ARTIFACT 2: HASHSET
        System.out.println("\n🌟 ARTIFACT 2: HashSet - The Uniqueness Guardian");
        System.out.println("   A Set that guarantees all elements are UNIQUE.");
        System.out.println("   Add a duplicate? It's silently ignored!");

        System.out.print("Q3: If you add the same item to a HashSet twice, what happens? ");
        String q3 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: Contains "ignore", "duplicate", "same", or "unique"
        if (q3.contains("ignore") || q3.contains("duplicate") || q3.contains("unique") || q3.contains("refuse")) {
            System.out.println("   ✅ CORRECT! HashSet automatically prevents duplicates.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. HashSet IGNORES duplicate additions.");
        }

        System.out.print("Q4: What is the time complexity of HashSet.contains()? ");
        String q4 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: "o(1)", "constant", "1", or "instant"
        if (q4.contains("o(1)") || q4.contains("constant") || q4.contains("instant") || q4.equals("1")) {
            System.out.println("   ✅ CORRECT! O(1) average—it hashes to find items directly!");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. HashSet lookups are O(1) average time.");
        }

        // ARTIFACT 3: HASHMAP
        System.out.println("\n💎 ARTIFACT 3: HashMap - The Key-Value Treasure");
        System.out.println("   A map that stores key-value pairs—like a dictionary!");
        System.out.println("   Lookup a key, get the value instantly.");

        System.out.print("Q5: In HashMap, what must be true about keys? ");
        String q5 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: Contains "unique", "distinct", "different", or "one"
        if (q5.contains("unique") || q5.contains("distinct") || q5.contains("different")) {
            System.out.println("   ✅ CORRECT! Keys must be UNIQUE. Duplicates overwrite.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. HashMap keys must be UNIQUE.");
        }

        System.out.println("\n🎉 Artifacts collected! You now understand the Collections Framework!");
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // QUEST 2: EXCEPTION DRAGON - Taming the Exception Dragon
    // ═══════════════════════════════════════════════════════════════════════════════
    private static void questTwoExceptionDragon(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  QUEST 2: THE EXCEPTION DRAGON                             ║");
        System.out.println("║  A dragon that throws exceptions stands before you.        ║");
        System.out.println("║  Learn to catch and handle its fury with try-catch!        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n🐉 The Dragon speaks: 'Can you handle my exceptions?'\n");

        System.out.print("Q1: What keyword is used to WRAP code that might throw an exception? ");
        String q1 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: "try"
        if (q1.equals("try")) {
            System.out.println("   ✅ CORRECT! TRY-catch blocks catch exceptions.");
            totalXP += 3;
        } else {
            System.out.println("   ❌ Incorrect. The keyword is TRY.");
        }

        System.out.print("Q2: What keyword passes exception handling to the caller? ");
        String q2 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: "throws"
        if (q2.equals("throws")) {
            System.out.println("   ✅ CORRECT! THROWS delegates responsibility upward.");
            totalXP += 3;
        } else {
            System.out.println("   ❌ Incorrect. The keyword is THROWS.");
        }

        System.out.print("Q3: What block ALWAYS executes, even if an exception occurred? ");
        String q3 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: "finally"
        if (q3.equals("finally")) {
            System.out.println("   ✅ CORRECT! FINALLY guarantees cleanup code runs.");
            totalXP += 3;
        } else {
            System.out.println("   ❌ Incorrect. The block is FINALLY.");
        }

        System.out.println("\n   Your wisdom shields you from the dragon's fire!");
        System.out.println("   The dragon bows in respect. You've learned exception mastery! 🏆");
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // QUEST 3: FILE VAULT - Unlocking the Secrets of File I/O
    // ═══════════════════════════════════════════════════════════════════════════════
    private static void questThreeFileVault(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  QUEST 3: THE FILE VAULT                                   ║");
        System.out.println("║  Ancient vaults hold knowledge, protected by File I/O      ║");
        System.out.println("║  secrets. Can you unlock them?                             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n🔐 You approach an ancient vault. Ancient runes cover it.\n");

        System.out.print("Q1: Which class is used to READ text from a file efficiently? ");
        String q1 = scanner.nextLine().trim();
        // ANSWER: "BufferedReader" (case-sensitive)
        if (q1.equals("BufferedReader")) {
            System.out.println("   ✅ CORRECT! BufferedReader reads ENTIRE LINES at once.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. The answer is BufferedReader.");
        }

        System.out.print("Q2: Which class is used to WRITE text to a file? ");
        String q2 = scanner.nextLine().trim();
        // ANSWER: "FileWriter" or "BufferedWriter"
        if (q2.equals("FileWriter") || q2.equals("BufferedWriter")) {
            System.out.println("   ✅ CORRECT! " + q2 + " writes data to files.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. Use FileWriter or BufferedWriter.");
        }

        System.out.print("Q3: What exception is thrown by most file operations? ");
        String q3 = scanner.nextLine().trim();
        // ANSWER: "IOException" (case-sensitive)
        if (q3.equals("IOException")) {
            System.out.println("   ✅ CORRECT! IOException is the checked exception for I/O errors.");
            totalXP += 2;
        } else {
            System.out.println("   ❌ Incorrect. The answer is IOException.");
        }

        // MINI CODE CHALLENGE
        System.out.println("\n⚔️ CODE CHALLENGE: Fill in the blanks!");
        System.out.println("   You need to write code to create a file. Fill in the missing parts:\n");
        
        System.out.println("   try {");
        System.out.println("       File myFile = new File(\"____\");  // TODO: What goes here? (hint: a filename)");
        System.out.print("       > ");
        String filename = scanner.nextLine().trim();
        if (!filename.isEmpty()) {
            System.out.println("       ✅ Good! You provided: " + filename);
            totalXP += 2;
        }

        System.out.println("\n       if (myFile.____()) {  // TODO: What method? (hint: checks existence)");
        System.out.print("       > ");
        String method = scanner.nextLine().trim().toLowerCase();
        if (method.contains("exist")) {
            System.out.println("       ✅ Good! The method is .exists()");
            totalXP += 2;
        } else {
            System.out.println("       ⚠️  The method is .exists()");
        }

        System.out.println("           System.out.println(\"File already exists!\");");
        System.out.println("       }");
        System.out.println("   } catch (______ e) {  // TODO: What exception type?");
        System.out.print("       > ");
        String exception = scanner.nextLine().trim();
        if (exception.equals("IOException")) {
            System.out.println("       ✅ Correct! IOException handles file operation errors.");
            totalXP += 3;
        } else {
            System.out.println("       ⚠️  The answer is IOException.");
        }

        System.out.println("       e.printStackTrace();");
        System.out.println("   }");

        System.out.println("\n🎉 The vault opens! Knowledge of file I/O is now yours!");
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // QUEST 4: RECURSION MAZE - Navigate the Recursive Labyrinth
    // ═══════════════════════════════════════════════════════════════════════════════
    private static void questFourRecursionMaze(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  QUEST 4: THE RECURSION MAZE                               ║");
        System.out.println("║  A twisted maze where the exit mirrors the entrance.       ║");
        System.out.println("║  Only those who understand recursion can escape!           ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n🌀 You enter the maze. The path spirals endlessly...\n");

        System.out.print("Q1: What stops a recursive function from looping forever? ");
        String q1 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: Contains "base" or "condition"
        if (q1.contains("base") || q1.contains("condition")) {
            System.out.println("   ✅ CORRECT! The BASE CASE stops recursion!");
            totalXP += 3;
        } else {
            System.out.println("   ❌ Incorrect. It's the BASE CASE.");
        }

        System.out.print("Q2: What must a recursive method do besides call itself? ");
        String q2 = scanner.nextLine().trim().toLowerCase();
        // ANSWER: Contains "progress" or "approach" or "get closer" or "base"
        if (q2.contains("progress") || q2.contains("approach") || q2.contains("closer") || q2.contains("simpler")) {
            System.out.println("   ✅ CORRECT! Each call must PROGRESS toward the base case!");
            totalXP += 3;
        } else {
            System.out.println("   ❌ Incorrect. It must PROGRESS toward the base case.");
        }

        // Factorial walkthrough
        System.out.println("\n⚔️ CODE CHALLENGE: Understanding Factorial Recursion\n");
        System.out.println("   public static int factorial(int n) {");
        System.out.println("       if (n <= 1) {  // This is the BASE CASE");
        System.out.println("           return 1;");
        System.out.println("       } else {  // This is the RECURSIVE CASE");
        System.out.println("           return n * factorial(n - 1);  // Progress toward base case!");
        System.out.println("       }");
        System.out.println("   }");
        System.out.println();

        System.out.print("Q3: What does factorial(4) return? (Calculate by hand if needed) ");
        String q3 = scanner.nextLine().trim();
        // ANSWER: "24" - 4 * 3 * 2 * 1 = 24
        if (q3.equals("24")) {
            System.out.println("   ✅ CORRECT! 4 * 3 * 2 * 1 = 24");
            totalXP += 3;
        } else {
            System.out.println("   ❌ Incorrect. 4! = 4 * 3 * 2 * 1 = 24");
        }

        System.out.println("\n🎉 The maze dissolves! You've mastered recursion!");
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // QUEST 5: BOSS BATTLE - The Final Test (Integration Challenge)
    // ═══════════════════════════════════════════════════════════════════════════════
    private static void questFiveBossBattle(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  FINAL BOSS BATTLE: THE INTEGRATION PHOENIX                ║");
        System.out.println("║  Defeat this boss by combining all your knowledge!         ║");
        System.out.println("║  Collections, Exceptions, File I/O, Recursion...           ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n🔥 A legendary phoenix rises before you!\n");

        // Challenge 1: Collections + Performance
        System.out.println("─ PHASE 1: Collections Knowledge ─");
        System.out.print("The phoenix asks: For 1,000,000 frequent lookups by key,\n" +
                        "would you use ArrayList, LinkedList, or HashMap? ");
        String phase1 = scanner.nextLine().trim().toLowerCase();
        if (phase1.contains("hashmap")) {
            System.out.println("✅ CORRECT! HashMap provides O(1) lookups. 500K iterations vs 1!");
            totalXP += 4;
        } else {
            System.out.println("❌ HashMap is best. It's O(1) vs ArrayList/LinkedList O(n).");
        }

        // Challenge 2: Exception Handling + File I/O
        System.out.println("\n─ PHASE 2: Exception & File Mastery ─");
        System.out.print("If you read from a file that doesn't exist, what exception\n" +
                        "is thrown? (Hint: It's a subclass of IOException) ");
        String phase2 = scanner.nextLine().trim();
        if (phase2.contains("FileNotFoundException")) {
            System.out.println("✅ CORRECT! FileNotFoundException signals a missing file.");
            totalXP += 4;
        } else {
            System.out.println("❌ FileNotFoundException is thrown when a file doesn't exist.");
        }

        // Challenge 3: Recursion Logic
        System.out.println("\n─ PHASE 3: Recursion Under Pressure ─");
        System.out.print("What's the base case condition for factorial? ");
        String phase3 = scanner.nextLine().trim().toLowerCase();
        if (phase3.contains("n <= 1") || phase3.contains("n == 1") || phase3.contains("n < 2") || 
            phase3.contains("less than") || phase3.contains("one") || phase3.contains("zero")) {
            System.out.println("✅ CORRECT! When n <= 1, return 1 (stop recursion).");
            totalXP += 4;
        } else {
            System.out.println("❌ The base case is n <= 1 (return 1).");
        }

        // Challenge 4: Integration Scenario
        System.out.println("\n─ PHASE 4: Ultimate Integration Challenge ─");
        System.out.print("Imagine reading 1M lines from a file into a Set to find\n" +
                        "unique entries. Why is this smart? ");
        String phase4 = scanner.nextLine().trim().toLowerCase();
        if (phase4.contains("duplicate") || phase4.contains("unique") || phase4.contains("auto") || 
            phase4.contains("automatically")) {
            System.out.println("✅ CORRECT! HashSet AUTOMATICALLY prevents duplicates!");
            totalXP += 4;
        } else {
            System.out.println("❌ HashSet automatically eliminates duplicates—no extra code!");
        }

        System.out.println("\n🎆 The phoenix is defeated!\n");
        System.out.println("   ╔══════════════════════════════════════════════╗");
        System.out.println("   ║         YOU ARE A JAVA MASTER! 🏆            ║");
        System.out.println("   ║   You've defeated the Integration Phoenix    ║");
        System.out.println("   ║  and mastered all the Final Exam concepts!   ║");
        System.out.println("   ╚══════════════════════════════════════════════╝");
    }

    // ═══════════════════════════════════════════════════════════════════════════════
    // HELPER METHODS - UI and Game Logic
    // ═══════════════════════════════════════════════════════════════════════════════

    private static void displayWelcome() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║        🎮 WELCOME TO THE JAVA QUEST: FINAL TRIALS 🎮       ║");
        System.out.println("║                                                            ║");
        System.out.println("║     You have survived the Midterm Gauntlet and now         ║");
        System.out.println("║     stand at the threshold of the legendary FINAL TRIALS!  ║");
        System.out.println("║                                                            ║");
        System.out.println("║  Master Collections, Exceptions, File I/O, Recursion,     ║");
        System.out.println("║  and Testing to become a true Java developer.             ║");
        System.out.println("║                                                            ║");
        System.out.println("║          Your journey begins now. Are you ready?           ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private static void displayGameStart(String playerName) {
        System.out.println("\n" + "═".repeat(60));
        System.out.printf("⚔️  Welcome, %s! Your adventure begins...\n", playerName);
        System.out.println("═".repeat(60));
        System.out.println("\n📜 OBJECTIVE: Complete quests, answer trivia, defeat the boss.");
        System.out.println("💰 Earn XP by answering questions correctly.");
        System.out.println("📊 Reach 30 XP to become a true Java Expert!");
        System.out.println();
    }

    private static void displayQuestMenu() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📋 AVAILABLE QUESTS:");
        System.out.println("═".repeat(60));
        System.out.println("1️⃣  Quest 1: Collections Artifacts");
        System.out.println("    └─ Master ArrayList, HashSet, and HashMap");
        System.out.println("\n2️⃣  Quest 2: The Exception Dragon");
        System.out.println("    └─ Learn try-catch-finally and exception handling");
        System.out.println("\n3️⃣  Quest 3: The File Vault");
        System.out.println("    └─ Unlock File I/O secrets with BufferedReader/Writer");
        System.out.println("\n4️⃣  Quest 4: The Recursion Maze");
        System.out.println("    └─ Navigate the twisted paths of recursive thinking");
        System.out.println("\n5️⃣  BOSS: The Integration Phoenix");
        System.out.println("    └─ Combine ALL knowledge to defeat the final boss!");
        System.out.println("\n6️⃣  Exit & View Final Stats");
        System.out.println("═".repeat(60));
    }

    private static void updateLevel() {
        // Level up formula: Every 6 XP increases level
        int newLevel = (totalXP / 6) + 1;
        if (newLevel > level) {
            level = newLevel;
            System.out.println("\n⭐ LEVEL UP! You are now LEVEL " + level + "! ⭐");
        }
    }

    private static void displayGameEnd(String playerName) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📊 FINAL RESULTS");
        System.out.println("═".repeat(60));
        System.out.printf("Player: %s\n", playerName);
        System.out.printf("Total XP Earned: %d / %d\n", totalXP, MAX_POSSIBLE_XP);
        System.out.printf("Final Level: %d\n", level);
        System.out.println("═".repeat(60));

        // Determine mastery level
        if (totalXP >= 27) {
            System.out.println("\n🏆🏆🏆 LEGENDARY JAVA MASTER 🏆🏆🏆");
            System.out.println("You have achieved mastery of all Final Exam concepts!");
            System.out.println("The legendary phoenix bows before your power. ✨");
        } else if (totalXP >= 20) {
            System.out.println("\n🥇 EXPERT JAVA DEVELOPER 🥇");
            System.out.println("You have solid mastery. Ready for the final exam!");
        } else if (totalXP >= 15) {
            System.out.println("\n🥈 ADVANCED JAVA PROGRAMMER 🥈");
            System.out.println("Good progress! Review weak areas before the exam.");
        } else if (totalXP >= 10) {
            System.out.println("\n🥉 INTERMEDIATE JAVA LEARNER 🥉");
            System.out.println("Keep studying! Return to strengthen your weaknesses.");
        } else {
            System.out.println("\n📚 JAVA APPRENTICE");
            System.out.println("Continue your studies and return for more challenges!");
        }

        System.out.println("\n🎓 Thank you for your dedication to learning Java!");
        System.out.println("   May your code compile cleanly and your logic be sound.");
        System.out.println("   Good luck on the final exam! 🚀");
        System.out.println("═".repeat(60) + "\n");
    }
}

/*
 * ═══════════════════════════════════════════════════════════════════════════════
 * 📚 STUDY TIPS FOR THE FINAL EXAM:
 * ═══════════════════════════════════════════════════════════════════════════════
 *
 * 1. COLLECTIONS FRAMEWORK
 *    • ArrayList: Dynamic, resizable. Fast random access O(1).
 *    • LinkedList: Node-based. Fast insertions/deletions at middle O(1).
 *    • HashSet: No duplicates. O(1) lookups. NO ORDER.
 *    • HashMap: Key-value pairs. O(1) lookups by key.
 *
 * 2. EXCEPTION HANDLING
 *    • Try-catch: Wrap risky code, catch specific exceptions
 *    • Finally: Always runs, even if exception occurred
 *    • Throws: Delegate exception to caller
 *    • Checked vs Unchecked: Checked MUST be handled
 *
 * 3. FILE I/O
 *    • FileReader/FileWriter: Character-based I/O
 *    • BufferedReader/BufferedWriter: More efficient (reads/writes in chunks)
 *    • IOException: The checked exception for file operations
 *    • Always close() your readers/writers!
 *
 * 4. RECURSION
 *    • Every recursive method MUST have a BASE CASE
 *    • Each recursive call must PROGRESS toward the base case
 *    • Base case prevents stack overflow
 *    • Recursion = method calling itself with simpler input
 *
 * 5. TESTING WITH JUNIT
 *    • @Test annotation marks test methods
 *    • assertEquals(expected, actual) for equality checks
 *    • assertTrue()/assertFalse() for boolean conditions
 *    • assertThrows() to verify exceptions are thrown
 *    • Edge cases matter: null, empty, boundaries, negative
 *
 * 6. BINARY SEARCH
 *    • MUST sort array first using Arrays.sort()
 *    • Time complexity: O(log n) vs linear O(n)
 *    • Algorithm: Compare middle, eliminate half each time
 *
 * 7. PERFORMANCE THINKING
 *    • ArrayList insert middle: O(n) - must shift elements
 *    • LinkedList insert middle: O(1) - just reconnect links
 *    • HashMap lookup: O(1) vs ArrayList linear O(n)
 *    • Choose the right data structure for your use case!
 *
 * Good luck on your final exam! You've got this! 🚀
 * ═══════════════════════════════════════════════════════════════════════════════
 */