package algsPractice.competition.ali;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskB {
  private static class UnilateralLine {
    private String id;
    private String sCen;//出发分拨
    private String sPro;//出发省
    private String eCen;//到达分拨
    private String ePro;//到达省
    //9.6m/17.5m
    private String tType;//车型

    public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
      this.id = id;
      this.sCen = sCen;
      this.sPro = sPro;
      this.eCen = eCen;
      this.ePro = ePro;
      this.tType = tType;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getSCen() {return sCen;}

    public void setSCen(String ePro) {this.ePro = ePro;}

    public String getSPro() {return sPro;}

    public void setSPro(String sPro) {this.sPro = sPro;}

    public String getECen() {return eCen;}

    public void setECen(String eCen) {this.eCen = eCen;}

    public String getEPro() {return ePro;}

    public void setEPro(String ePro) {this.ePro = ePro;}

    public String getTType() {return tType;}

    public void setTType(String tType) {this.tType = tType;}
  }

  private List<String> calculateRule1(List<UnilateralLine> lineList) {
    List<String> result = new ArrayList<String>();

    for (Iterator<UnilateralLine> iter = lineList.iterator(); iter.hasNext(); ) {
      UnilateralLine line = iter.next();
      String cpKey = getCPKeyReverse(line);
      Set<UnilateralLine> set = cpCenMap.get(cpKey);
      int sum96 = 0;
      boolean check96 = "17.5m".equals(line.tType);
      if (set == null) {
        continue;
      }
      for (UnilateralLine unilateralLine : set) {
        if (line.tType.equals(unilateralLine.tType)) {
          result.add(String.format("rule1:%s+%s", line.id, unilateralLine.id));
        }
      }
    }

    return result;
  }

  private List<String> calculateRule2(List<UnilateralLine> lineList) {
    List<String> result = new ArrayList<String>();
    return result;
  }

  private List<String> calculateRule3(List<UnilateralLine> lineList) {
    List<String> result = new ArrayList<String>();
    return result;
  }


  private List<String> calculateUnilateral(List<UnilateralLine> lineList) {
    List<String> result = new ArrayList<String>();
    result.addAll(calculateRule1(lineList));
    result.addAll(calculateRule2(lineList));
    result.addAll(calculateRule2(lineList));
    return result;
  }

  private String getCPKey(UnilateralLine line) {
    String key = line.sCen + "|" + line.sPro + "|" + line.eCen + "|" + line.ePro;
    return key;
  }

  private String getPKey(UnilateralLine line) {
    String key = line.sPro + "|" + line.ePro;
    return key;
  }

  private String getCPKeyReverse(UnilateralLine line) {
    String key = line.eCen + "|" + line.ePro + "|" + line.sCen + "|" + line.sPro;
    return key;
  }

  private String getPKeyReverse(UnilateralLine line) {
    String key = line.ePro + "|" + line.sPro;
    return key;
  }

  private void deleteData(UnilateralLine line) {
    String cpKey = getCPKey(line);
    cpCenMap.get(cpKey).remove(line);
    String pKey = getPKey(line);
    pCenMap.get(pKey).remove(line);
  }

  private void prepareData(UnilateralLine line) {
    String cpKey = getCPKey(line);
    String pKey = getPKey(line);
    if (cpCenMap.get(cpKey) == null) {
      cpCenMap.put(cpKey, new HashSet<UnilateralLine>());
    }

    if (pCenMap.get(pKey) == null) {
      pCenMap.put(pKey, new HashSet<UnilateralLine>());
    }
    cpCenMap.get(cpKey).add(line);
    pCenMap.get(pKey).add(line);
  }

  // private void prepareData(UnilateralLine line) {
  //     String sCen = line.sCen;
  //     String eCen = line.eCen;
  //     if (eCenMap.get(eCen) == null) {
  //         eCenMap.put(eCen, new HashSet<UnilateralLine>());
  //     }
  //     if (sCenMap.get(sCen) == null) {
  //         sCenMap.put(sCen, new HashSet<UnilateralLine>());
  //     }
  //     eCenMap.get(eCen).add(line);
  //     sCenMap.get(sCen).add(line);
  // }
  //
  // private HashMap<String, HashSet<UnilateralLine>> sCenMap;
  // private HashMap<String, HashSet<UnilateralLine>> eCenMap;
  private HashMap<String, HashSet<UnilateralLine>> cpCenMap;
  private HashMap<String, HashSet<UnilateralLine>> pCenMap;


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    cpCenMap = new HashMap<String, HashSet<UnilateralLine>>();
    pCenMap = new HashMap<String, HashSet<UnilateralLine>>();
    List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
    String s;
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    while ((s = in.nextLine()) != null) {
      String[] options = s.split(";");
      if (options.length < 5) {
        break;
      }
      UnilateralLine line = new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]);
      lineList.add(line);
      prepareData(line);
    }

    // wirte your code here
    List<String> result = calculateUnilateral(lineList);

    for (String str : result) {
      System.out.println(str);
    }
  }
}
