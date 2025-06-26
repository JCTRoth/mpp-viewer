import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class CustomTableHeaderRenderer extends JLabel implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int sortColumn = -1;
    private boolean ascending = true;

    public void setSortState(int sortColumn, boolean ascending) {
        this.sortColumn = sortColumn;
        this.ascending = ascending;
    }

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		String text = value == null ? "" : value.toString();
		// Add sorting indicator if this is the sorted column
		if (column == sortColumn) {
			String arrow = ascending ? " \u25B2" : " \u25BC"; // ? or ?
			text += arrow;
		}
		setText("<HTML><div style='font-weight:normal'>"+text+"</div></HTML>");
		setPreferredSize(new Dimension(10, 32));
		setVerticalAlignment(TOP);
		setOpaque(true);
		setBackground(new Color(223,227,232));
		return this;
	}
	
}