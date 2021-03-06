/**
 * Custom TableCellRenderer to render buttons in JTable cells
 *
 * @author Yuko Takegoshi
 */

package calculator;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class JTableButtonRenderer implements TableCellRenderer {
  @Override
  public JButton getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    JButton button = (JButton) value;

    return button;
  }
}
