/* *****************************************************************************
 *  Name:      Yufang Lu
 *  NetID:     yufangl
 *  Precept:   P14
 *
 *  Partner Name:       /
 *  Partner NetID:      /
 *  Partner Precept:    /
 **************************************************************************** */

Which partner is submitting the program files?
No partner.

Final Programming Project: Atomic Nature of Matter

Hours to complete assignment (optional):


/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of n?          *
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/

Input size n    Time/s    Tn/T(n/2)
      10        0.396         /
      20        0.514        1.29
      40        0.839        1.63
      80        1.403        1.67
     160        2.613        1.86

Using doubling method and solve for b = lg(TN/TN/2);
b is about 1 (or smaller that 1), so running time as a function of n is linear.
so T = 0.019 * n;

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?

No.

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?

No.

/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/

For the StdIn of the BeadTracker. In the testing example, it is run_1/*.jpg.
It's not quite claer cause I thought I should read the folder with the StdIn
above. Then I realized it just requires us to read every single file when
sbumitting the java file.
