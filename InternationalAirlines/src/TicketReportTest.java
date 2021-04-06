package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

class TicketReportTest {

  @Test
  public void loadData_Using_TicketReportMock() {
    //create mock TicketReport object
    TicketReport mockReport = Mockito.spy(new TicketReport());

    //Prevent LoadData from being used but still called.
    Mockito.doNothing().when(mockReport).LoadData();

    //call initComponents (tested method)  to see if it loads data
    mockReport.initComponents();
    //Check to see if the LoadData has been accessed.
    verify(mockReport, times(1)).LoadData();
  }
}