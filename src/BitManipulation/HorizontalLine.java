/**
 * You are given a monochrome bitmap as a byte array (together with its width W
 * and height H). Draw a horizontal line between (x1, y) and (x2, y)
 *
 */
package BitManipulation;

public class HorizontalLine {

	public static void drawHorizontalLine(
			final byte[] bitmap, final int w, final int h, final int x1, final int x2,
			final int y) {

		if (((x2 - x1) > w) || (y > h)) {
			throw new IllegalArgumentException();
		}

		final int startBit = (w * y) + x1;
		final int endBit = (w * y) + x2;

		final int startByte = startBit / 8;
		final int startBitInFirstByte = (startBit % 8);

		final int endByte = endBit / 8;
		final int endBitInEndByte = (endBit % 8) + 1;

		for (int i = startByte + 1; i < endByte; i++) {
			bitmap[i] = (byte) 0xFF;
		}

		final byte startByteVal = (byte) (0xFF >> startBitInFirstByte);
		final byte endByteVal = (byte) (0xFF << (8 - endBitInEndByte));

		if (startByte == endByte) {
			bitmap[startByte] = (byte) (startByteVal & endByteVal);
		} else {
			bitmap[startByte] = startByteVal;
			bitmap[endByte] = endByteVal;
		}
	}

	public static void printBitmap(final byte[] bitmap, final int w, final int h) {
		final StringBuilder sb = new StringBuilder();
		for(int i=0; i<h; i++) {
			for(int j=0; j < w; j++) {
				final int bitPos = (i * w) + j;
				final int bytePos = bitPos / 8;
				final int bitInByte = (bitPos % 8) + 1;

				final byte b = bitmap[bytePos];

				final int bitVal = (b >> (8 - bitInByte)) & 0x01;
				final String cVal = bitVal == 1 ? "#" : ".";
				sb.append(cVal);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void main(final String[] args) {
		final int w = 100, h = 10, x1 = 4, x2 = 40, y = 4;
		final int size = (int) Math.ceil((w * h * 1.0) / 8);
		final byte[] b = new byte[size];// { 0x0, 0x6, 0x0 };
		printBitmap(b, w, h);
		drawHorizontalLine(b, w, h, x1, x2, y);
		printBitmap(b, w, h);
	}
}