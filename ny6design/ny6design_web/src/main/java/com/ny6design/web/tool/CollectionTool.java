package com.ny6design.web.tool;

import java.util.List;

public class CollectionTool {

	public CollectionTool() {
	}

	public int size(Object o) {
		if (o instanceof List) {
			List l = (List) o;
			return l.size();
		}
		return 0;
	}

	public boolean isNull(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof List) {
			List l = (List) o;
			return l.isEmpty();
		}
		return true;
	}

}
