package algsPractice.lib;

import net.egork.chelper.checkers.Checker;
import net.egork.chelper.checkers.TokenChecker;
import net.egork.chelper.tester.Verdict;

/**
 * Created by Scruel on 2017/5/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */

public class MyChecker implements Checker {
    public static final Verdict SKIPPED;
    public static final Verdict UNDECIDED;
    public static final Verdict OK;
    public static final Verdict WA;
    //    public static final Verdict RTE;
    public static final Verdict PE;
    public static TokenChecker tk;


    static {
        SKIPPED = new Verdict(Verdict.VerdictType.SKIPPED, null);
        UNDECIDED = new Verdict(Verdict.VerdictType.UNDECIDED, null);
        OK = new Verdict(Verdict.VerdictType.OK, null);
        WA = new Verdict(Verdict.VerdictType.WA, null);
//        RTE = new Verdict(Verdict.VerdictType.RTE, null);
        PE = new Verdict(Verdict.VerdictType.PE, null);
    }

    public MyChecker(String parameters) {
        tk = new TokenChecker(parameters);
    }

    public Verdict check(String input, String expectedOutput, String actualOutput) {
        if (expectedOutput == null) return UNDECIDED;
        Verdict v = actualOutput.equals(expectedOutput) ? OK : WA;
        if (v == OK) return v;
        v = tk.check(input, expectedOutput, actualOutput);
        if (v == OK) return PE;
        return WA;
    }
}

