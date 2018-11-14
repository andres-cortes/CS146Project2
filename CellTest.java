import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest
{
	Cell a;
	Cell b;
	Cell c;

	// simple cell tests are done here. More complicated tests in MazeTest
	@BeforeEach
	void setUp() throws Exception
	{
		a = new Cell();
		b = new Cell();
		c = new Cell();
		a.setNorth(b);
		b.setEast(c);
	}

	@AfterEach
	void tearDown() throws Exception
	{

	}

	@Test
	void testConnectivity()
	{
		assert (c.getWest() == b);
		assert (b.getSouth() == a);
	}

	@Test
	void testDeadEnd()
	{
		assert (c.deadEnd());
		assert (!b.deadEnd());
	}

}
