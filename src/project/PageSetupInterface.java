package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public interface PageSetupInterface {
  double PIXEL_PER_INCH=72;

  double PAPER_HEIGHT=11*PIXEL_PER_INCH;
  double PAPER_WIDTH= 8*PIXEL_PER_INCH;

  double LEFT_MARGIN=0.5*PIXEL_PER_INCH;
  double RIGHT_MARGIN=0*PIXEL_PER_INCH;
  double TOP_MARGIN=0.5*PIXEL_PER_INCH;
  double BOTTOM_MARGIN=0.0*PIXEL_PER_INCH;

  double PAPER_HEIGHT_A5 = 5.3*PIXEL_PER_INCH;
  double PAPER_WIDTH_A5= 8.5*PIXEL_PER_INCH;

  boolean LANDSCAPE=false;
}
