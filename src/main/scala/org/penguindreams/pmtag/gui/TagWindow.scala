import marad.scala.swt.builder.ShellBuilder
import org.eclipse.swt.browser.Browser
import org.eclipse.swt.events.{SelectionEvent, SelectionAdapter}
import org.eclipse.swt.widgets._
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.layout.GridDataFactory

object TagWindow  {

  def main(args : Array[String]) {

    val display =  new Display()

    val sh = new ShellBuilder(display) {
      shell text "pmTag" gridLayout (2,true)
      /*group text "Name" gridLayout 2 gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
        label text "First";
        edit text "Bullet" gridData (SWT.FILL, SWT.CENTER, true, true) name "first"
        label text "Last";
        edit text "Tooth" gridData (SWT.FILL, SWT.CENTER, true, true) name "last"
      } */
      group text "Tags" fillLayout 2 gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
        0 to 20 map { i =>
          checkbox
          label text "Tag %d".format(i)
        }
      }
      button text "Close" gridData (SWT.LEFT, SWT.CENTER, true, true) onSelect {
        shell close
      }
    } shell()
    sh.pack
    sh.open

    while(!sh.isDisposed) {
      if(!display.readAndDispatch) {
        display.sleep
      }
    }
    display.dispose
  }
}