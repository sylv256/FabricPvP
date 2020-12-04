package io.github.hydos.cscerns.xml;

import net.minecraft.client.gui.widget.ButtonWidget;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlScreenParser {
	private Document document;

	private final List<ButtonWidget> buttons = new ArrayList<>();

	public XmlScreenParser(String fileLocation) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			this.document = builder.parse(XmlScreenParser.class.getResourceAsStream(fileLocation));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ButtonWidget> getButtons() {
		return buttons;
	}

	public void parse(int screenWidth) {
		document.getDocumentElement().normalize();
		NodeList nodeList = document.getElementsByTagName("button");
		int defaultButtonWidth = 200;
		int defaultButtonHeight = 20;

		int placementX = -200;
		int placementY = 0;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				int x = placementX + defaultButtonWidth;
				this.buttons.add(new ButtonWidget(i, x, placementY, element.getTextContent()));
				placementX = placementX + defaultButtonWidth;

				if(placementX + (defaultButtonWidth * 2) > screenWidth){
					placementX = -200;
					placementY = placementY + defaultButtonHeight;
				}
			}
		}
	}
}
