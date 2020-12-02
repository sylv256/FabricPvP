package io.github.hydos.realcssparser;

import org.w3c.dom.css.CSSStyleSheet;

import java.util.HashMap;
import java.util.Map;

/**
 * because no other libraries are good
 *
 * @author hydos
 * @version 1.0.0
 */
public class RealCssParser {

    private final CSSStyleSheet styleSheet;
    private int screenWidth;
    private int screenHeight;

    private final Map<String, ElementData> cachedElements = new HashMap<>();

    public RealCssParser(int screenWidth, int screenHeight, CSSStyleSheet styleSheet) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.styleSheet = styleSheet;
    }

    public void addElement(String cssSelector, String id) {
        cachedElements.put(id, new ElementData(cssSelector));
    }

    public void clearOldData() {
        cachedElements.clear();
    }

    public void onScreenResize(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        calculatePositions();
    }

    public void calculatePositions() {
        cachedElements.values().forEach(element -> {
            //TODO: yes
            System.out.println(screenHeight);
            System.out.println(screenWidth);
            System.out.println(styleSheet);
        });
    }

    public ElementData getData(String id) {
        return cachedElements.get(id);
    }

    private static class ElementData {
        private final String cssSelector;
        public String xPos;
        public String yPos;

        public ElementData(String cssSelector) {
            this.cssSelector = cssSelector;
        }

        public String getCssSelector() {
            return cssSelector;
        }

        public String getxPos() {
            return xPos;
        }

        public String getyPos() {
            return yPos;
        }
    }
}

//public class CSSParserTest
//{
//
//    protected static CSSParserTest oParser;
//
//    public static void main(String[] args) {
//
//        oParser = new CSSParserTest();
//
//        if (oParser.Parse("design.css")) {
//
//            System.out.println("Parsing completed OK");
//
//        } else {
//
//            System.out.println("Unable to parse CSS");
//
//        }
//    }
//
//
//    public boolean Parse(String cssfile)
//    {
//
//        FileOutputStream out = null;
//        PrintStream ps = null;
//        boolean rtn = false;
//
//        try
//        {
//
//            // cssfile accessed as a resource, so must be in the pkg (in src dir).
//            InputStream stream = oParser.getClass().getResourceAsStream(cssfile);
//
//            // overwrites and existing file contents
//            out = new FileOutputStream("log.txt");
//
//            if (out != null)
//            {
//                //log file
//                ps = new PrintStream( out );
//                System.setErr(ps); //redirects stderr to the log file as well
//
//            } else {
//
//                return rtn;
//
//            }
//
//
//            InputSource source = new InputSource(new InputStreamReader(stream));
//            CSSOMParser parser = new CSSOMParser();
//            // parse and create a stylesheet composition
//            CSSStyleSheet stylesheet = parser.parseStyleSheet(source, null, null);
//
//            //ANY ERRORS IN THE DOM WILL BE SENT TO STDERR HERE!!
//            // now iterate through the dom and inspect.
//
//            CSSRuleList ruleList = stylesheet.getCssRules();
//
//            ps.println("Number of rules: " + ruleList.getLength());
//
//
//            for (int i = 0; i < ruleList.getLength(); i++)
//            {
//                CSSRule rule = ruleList.item(i);
//                if (rule instanceof CSSStyleRule)
//                {
//                    CSSStyleRule styleRule=(CSSStyleRule)rule;
//                    ps.println("selector:" + i + ": " + styleRule.getSelectorText());
//                    CSSStyleDeclaration styleDeclaration = styleRule.getStyle();
//
//
//                    for (int j = 0; j < styleDeclaration.getLength(); j++)
//                    {
//                        String property = styleDeclaration.item(j);
//                        ps.println("property: " + property);
//                        ps.println("value: " + styleDeclaration.getPropertyCSSValue(property).getCssText());
//                        ps.println("priority: " + styleDeclaration.getPropertyPriority(property));
//                    }
//
//
//
//                }// end of StyleRule instance test
//            } // end of ruleList loop
//
//            if (out != null) out.close();
//            if (stream != null) stream.close();
//            rtn = true;
//        }
//        catch (IOException ioe)
//        {
//            System.err.println ("IO Error: " + ioe);
//        }
//        catch (Exception e)
//        {
//            System.err.println ("Error: " + e);
//
//        }
//        finally
//        {
//            if (ps != null) ps.close();
//        }
//
//        return rtn;
//
//    }
//
//}
