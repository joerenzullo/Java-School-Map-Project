package test;

public class User
{
	public Vertex[] PFD;
	public int ID;
	
	/**
	 * constructor for a user- its main feature is its own unique set of pathfinding Data
	 * @param id integer for what that user's number is.
	 */
	public User(int id)
    {
		ID = id;
    	PFD = createPFD(); 
    }
	
	/**
	 * goes through the list of vertices and returns the one of the desired name. 
	 * @param Name
	 * @return the vertices with the name. If it does not exist it returns the 30th- in this case, 'CC2' 
	 */
	public Vertex findVertexNamed(String Name)
    {
    	for(Vertex v : PFD)
    	{
    		if(v.name == Name)
    			return v;
    	}
    	return PFD[0];
    }
	
	/**
	 * resets the pathfinding data (list of vertices) of the user.
	 */
	public void resetPFD()
    {
    	for(Vertex v : PFD)
    		v.reset();
    }
	
	/**
	 * simply a helper function used to return the double of the distance between two vertices.
	 * @param source vertex one
	 * @param destination vertex two
	 * @return distance between the two vertices using their x and y positions.
	 */
	public double pythagDistance(Vertex source, Vertex destination)
	{
		return Math.sqrt(Math.pow(source.posx-destination.posx, 2) + Math.pow(source.posy-destination.posy, 2));
	}
	
	public String findclosestVertexName(int posx, int posy)
	{
		double lowestDistance = Integer.MAX_VALUE;
		Vertex hold = PFD[0];
		for(Vertex v : PFD)
		{
			if(lowestDistance > Math.sqrt(Math.pow(posx-v.posx, 2) + Math.pow(posy-v.posy, 2)))
			{
				hold = v;
				lowestDistance = Math.sqrt(Math.pow(posx-v.posx, 2) + Math.pow(posy-v.posy, 2)); 
			}
		}
		return hold.name;
	}
	/**
	 * creates and fills an array of vertices that PFD will be set to.
	 * @return an array of vertices that PFD will be set to.
	 */
	public Vertex[] createPFD()
    {
    	/**
    	 * beginning of creation of building nodes which don't connect to anything,
    	 *  used as endpoints.
    	 *  name, x pos, y pos. x and y are used for drawing lines and such later.
    	 */
    	Vertex VHH = new Vertex ("VHH", 205, 40); //
    	Vertex VL = new Vertex ("VL", 205, 80); //
    	Vertex VCC = new Vertex ("VCC", 125, 125); //
    	Vertex VD = new Vertex ("VD", 285, 100); //
    	Vertex VIT = new Vertex ("VIT", 70, 285); //
    	Vertex VB = new Vertex ("VB", 120, 220); //
    	Vertex VC = new Vertex("VC", 365, 195); //
    	Vertex VG = new Vertex ("VG", 195, 190); //
    	Vertex VR = new Vertex ("VR", 210, 210); //
    	Vertex VZ = new Vertex ("VZ", 195, 245); //
    	Vertex VE = new Vertex ("VE", 450, 100); //
    	Vertex VLL = new Vertex ("VLL", 535, 100);//
    	Vertex VU = new Vertex ("VU", 535, 220);//
    	Vertex VUU = new Vertex ("VUU", 585, 205);//
    	Vertex VW = new Vertex ("VW", 145, 305); //
    	Vertex VLP = new Vertex ("VLP", 250, 300); //
    	Vertex VP = new Vertex ("VP", 113, 395); // 
    	Vertex VO = new Vertex ("VO", 111, 419); //
    	Vertex VFS = new Vertex ("VFS", 170, 400); //
    	Vertex VFB = new Vertex ("VFB", 230, 405); //
    	Vertex VFC = new Vertex ("VFC", 275, 385); // 
    	Vertex VGM = new Vertex ("VGM", 275, 390); //
    	Vertex VCA = new Vertex ("VCA", 385, 325); //
    	Vertex VV = new Vertex ("VV", 380, 265); // 
    	Vertex VSV = new Vertex ("VSV", 595, 520); //
    	Vertex VAMP = new Vertex ("VAMP", 465, 270); //
    	Vertex VPLAZ = new Vertex ("VPLAZ", 490, 165); //
    	Vertex VAN = new Vertex ("VAN", 480, 385);
    	Vertex VS = new Vertex ("VS", 380, 400);

		
		/*
    	 * beginning of creation of Path-finding nodes which are used to
    	 *  get to a building used as endpoints.
    	 *  name, x pos, y pos. x and y are used for drawing lines and finding weights for edges.
    	 */
		Vertex L1 = new Vertex ("L1", 161, 42); // //
		Vertex HH = new Vertex ("HH", 207, 21); // //
		Vertex L2 = new Vertex ("l2", 255, 50); // //
		Vertex CC1 = new Vertex ("CC1", 165, 80); // //
		Vertex D1 = new Vertex ("D1", 255, 95); // //
		Vertex D4 = new Vertex ("D4", 320, 100); // //
		Vertex E1 = new Vertex ("E1", 420, 100); // //
		Vertex CC2 = new Vertex ("CC2", 162, 130); // //
		Vertex L3 = new Vertex ("L3", 210, 130);//
		Vertex D2 = new Vertex ("D2", 255, 130);//
		Vertex D3 = new Vertex ("D3", 295, 130);//
		Vertex C1 = new Vertex ("C1", 320, 130);//
		Vertex C2 = new Vertex ("C2", 350, 130);//
		Vertex C3 = new Vertex ("C3", 380, 130);//
		Vertex E2 = new Vertex ("E2", 420, 130);//
		Vertex E3 = new Vertex ("E3", 452, 135);//
		Vertex PLAZ = new Vertex ("PLAZ", 485, 135);//
		Vertex LL = new Vertex ("LL", 540, 135);//
		Vertex UU1 = new Vertex ("UU1", 580, 135);//
		Vertex C4 = new Vertex ("C4", 440, 167);//
		Vertex U1 = new Vertex ("U1", 513, 165);//
		Vertex UU2 = new Vertex ("UU2", 586, 180);//
		Vertex B1 = new Vertex ("B1", 90, 195);//
		Vertex B2 = new Vertex ("B2", 142, 192);//
		Vertex G = new Vertex ("G", 212, 190);//
		Vertex R4 = new Vertex ("R4", 295, 190);//
		Vertex IT1 = new Vertex ("IT1", 93, 245);//
		Vertex R1 = new Vertex ("R1", 160, 240);//
		Vertex Z = new Vertex ("Z", 205, 230);//
		Vertex R3 = new Vertex ("R3", 265, 240);//
		Vertex R5 = new Vertex ("R5", 300, 240);//
		Vertex C5 = new Vertex ("C5", 340, 245);//
		Vertex C6 = new Vertex ("C6", 400, 245);//
		Vertex V2 = new Vertex ("V2", 445, 245);//
		Vertex AMP = new Vertex ("AMP", 485, 250);//
		Vertex W1 = new Vertex ("W1", 160, 260);//
		Vertex LP1 = new Vertex ("LP1", 265, 260);//
		Vertex V1 = new Vertex ("V1", 310, 265);//
		Vertex U2 = new Vertex ("U2", 515, 275);//
		Vertex IT2 = new Vertex ("IT2", 93, 285);//
		Vertex LP2 = new Vertex ("LP2", 265, 300);//
		Vertex CA1 = new Vertex ("CA1", 310, 320);//
		Vertex IT3 = new Vertex ("IT3", 95, 345);//
		Vertex W2 = new Vertex ("W2", 135, 260);//
		Vertex FS = new Vertex ("FS", 210, 360);//
		Vertex FC = new Vertex ("FC", 260, 355);//
		Vertex GM1 = new Vertex ("GM1", 305, 355);//
		Vertex CA2 = new Vertex ("CA2", 450, 360);//
		Vertex P1 = new Vertex ("P1", 520, 362);//
		Vertex P = new Vertex ("P", 130, 395);//
		Vertex O = new Vertex ("O", 130, 420);//
		Vertex FB = new Vertex ("FB", 252, 415);//
		Vertex GM2 = new Vertex ("GM2", 460, 400);//
		Vertex P2 = new Vertex ("P2", 520, 455);//
		Vertex SV = new Vertex ("SV", 586, 465);//
		Vertex STAD = new Vertex ("STAD", 500, 480);//
		
		
		/**
		 * beginning of creating the edges.
		 */
		
		VHH.adjacencies = new Edge[]{new Edge(HH, pythagDistance(VHH, HH))};
    	VL.adjacencies = new Edge[]{new Edge(L3, pythagDistance(VL, L3))}; 
    	VCC.adjacencies = new Edge[]{new Edge(CC2, pythagDistance(VCC, CC2))};
    	VD.adjacencies = new Edge[]{new Edge(D3, pythagDistance(VD, D3))};
    	VIT.adjacencies = new Edge[]{new Edge(IT2, pythagDistance(VIT, IT2))};
    	VB.adjacencies = new Edge[]{new Edge(B2, pythagDistance(VB, B2))};
    	VC.adjacencies = new Edge[]{new Edge(R4, pythagDistance(VC, R4)),
    								new Edge(C4, pythagDistance(VC, C4))};
    	VG.adjacencies = new Edge[]{new Edge(G, pythagDistance(VG, G))};
    	VZ.adjacencies = new Edge[]{new Edge(Z, pythagDistance(VZ, Z))};
    	VR.adjacencies = new Edge[]{new Edge(G, pythagDistance(VR, G)),
    								new Edge(Z, pythagDistance(VR, Z))};
    	VE.adjacencies = new Edge[]{new Edge(E3, pythagDistance(VE, E3))};
    	VLL.adjacencies = new Edge[]{new Edge(LL, pythagDistance(VLL, LL))};
    	VU.adjacencies = new Edge[]{new Edge(U1, pythagDistance(VU, U1))};
     	VUU.adjacencies = new Edge[]{new Edge(UU2, pythagDistance(VUU, UU2))};
     	VW.adjacencies = new Edge[]{new Edge(W1, pythagDistance(VW, W1))};
     	VLP.adjacencies = new Edge[]{new Edge(LP2, pythagDistance(VLP, LP2))};
     	VP.adjacencies = new Edge[]{new Edge(P, pythagDistance(VP, P))};
     	VO.adjacencies = new Edge[]{new Edge(O, pythagDistance(VO, O))};
     	VFS.adjacencies = new Edge[]{new Edge(FS, pythagDistance(VFS, FS))};
     	VFB.adjacencies = new Edge[]{new Edge(FB, pythagDistance(VFB, FB))};
     	VFC.adjacencies = new Edge[]{new Edge(FC, pythagDistance(VFC, FC))};
     	VGM.adjacencies = new Edge[]{new Edge(GM1, pythagDistance(VGM, GM1))};
     	VCA.adjacencies = new Edge[]{new Edge(CA1, pythagDistance(VCA, CA1))};
     	VV.adjacencies = new Edge[]{new Edge(V1, pythagDistance(VV, V1)),
     								new Edge(V2, pythagDistance(VV, V2))};
     	VSV.adjacencies = new Edge[]{new Edge(SV, pythagDistance(VSV, SV))};
     	VAMP.adjacencies = new Edge[]{new Edge(AMP, pythagDistance(VAMP, AMP))};
    	VPLAZ.adjacencies = new Edge[]{new Edge(PLAZ, pythagDistance(VPLAZ, PLAZ))};
    	VAN.adjacencies = new Edge[]{new Edge(GM2, pythagDistance(VAN, GM2))};
    	VS.adjacencies = new Edge[]{new Edge(STAD, pythagDistance(VS, STAD))};
		
		
		
		
		L1.adjacencies = new Edge[]{new Edge(HH, pythagDistance(L1, HH)),
             						new Edge(CC1, pythagDistance(L1, CC1))};
		HH.adjacencies = new Edge[]{new Edge(L1, pythagDistance(HH, L1)),
									new Edge(L2, pythagDistance(HH, L2)),
									new Edge(VHH, pythagDistance(HH, VHH))};
		L2.adjacencies = new Edge[]{new Edge(HH, pythagDistance(L2, HH)),
									new Edge(D1, pythagDistance(L2, D1))};
		CC1.adjacencies = new Edge[]{new Edge(L1, pythagDistance(CC1, L1)),
									new Edge(CC2, pythagDistance(CC1, CC2)),
									new Edge(VCC, pythagDistance(CC1, VCC))};
		D1.adjacencies = new Edge[]{new Edge(L2, pythagDistance(D1, L2)),
									new Edge(D2, pythagDistance(D1, D2))};
		D4.adjacencies = new Edge[]{new Edge(VD, pythagDistance(D4, VD)),
									new Edge(C1, pythagDistance(D4, C1)),
									new Edge(C2, pythagDistance(D4, C2)),
									new Edge(E1, pythagDistance(D4, E1))};
		E1.adjacencies = new Edge[]{new Edge(VE, pythagDistance(E1, VE)),
									new Edge(C3, pythagDistance(E1, C3)),
									new Edge(E2, pythagDistance(E1, E2))};
		CC2.adjacencies = new Edge[]{new Edge(VCC, pythagDistance(CC2, VCC)),
									new Edge(CC1, pythagDistance(CC2, CC1)),
									new Edge(L3, pythagDistance(CC2, L3)),
									new Edge(R4, pythagDistance(CC2, R4)),
									new Edge(G, pythagDistance(CC2, G)),
									new Edge(B2, pythagDistance(CC2, B2))};
		L3.adjacencies = new Edge[]{new Edge(VL, pythagDistance(L3, VL)),
									new Edge(CC2, pythagDistance(L3, CC2)),
									new Edge(B2, pythagDistance(L3, B2)),
									new Edge(G, pythagDistance(L3, G)),
									new Edge(R4, pythagDistance(L3, R4)),
									new Edge(D2, pythagDistance(L3, D2))};
		D2.adjacencies = new Edge[]{new Edge(D1, pythagDistance(D2, D1)),
									new Edge(L3, pythagDistance(D2, L3)),
									new Edge(D3, pythagDistance(D2, D3)),
									new Edge(B2, pythagDistance(D2, B2)),
									new Edge(G, pythagDistance(D2, G)),
									new Edge(R4, pythagDistance(D2, R4))};
		D3.adjacencies = new Edge[]{new Edge(VD, pythagDistance(D3, VD)),
									new Edge(D2, pythagDistance(D3, D2)),
									new Edge(C1, pythagDistance(D3, C1)),
									new Edge(B2, pythagDistance(D3, B2)),
									new Edge(G, pythagDistance(D3, G)),
									new Edge(R4, pythagDistance(D3, R4))};
		C1.adjacencies = new Edge[]{new Edge(D4, pythagDistance(C1, D4)),
									new Edge(D3, pythagDistance(C1, D3)),
									new Edge(C2, pythagDistance(C1, C2))};
		C2.adjacencies = new Edge[]{new Edge(C1, pythagDistance(C2, VL)),
									new Edge(D4, pythagDistance(C2, VL)),
									new Edge(C3, pythagDistance(C2, VL)),
									new Edge(VC, pythagDistance(C2, VC)),
									new Edge(R4, pythagDistance(C2, R4)),
									new Edge(R5, pythagDistance(C2, R5)),
									new Edge(C4, pythagDistance(C2, C4))};
		C3.adjacencies = new Edge[]{new Edge(C2, pythagDistance(C3, C2)),
									new Edge(E1, pythagDistance(C3, E1)),
									new Edge(E2, pythagDistance(C3, E2)),
									new Edge(R4, pythagDistance(C3, R4)),
									new Edge(R5, pythagDistance(C3, R5)),
									new Edge(C4, pythagDistance(C3, C4))};
		E2.adjacencies = new Edge[]{new Edge(C3, pythagDistance(E2, C3)),
									new Edge(E1, pythagDistance(E2, E1)),
									new Edge(E3, pythagDistance(E2, E3)),
									new Edge(C4, pythagDistance(E2, C4))};
		E3.adjacencies = new Edge[]{new Edge(VE, pythagDistance(E3, VE)),
									new Edge(E2, pythagDistance(E3, E2)),
									new Edge(C4, pythagDistance(E3, C4)),
									new Edge(PLAZ, pythagDistance(E3, PLAZ))};
		PLAZ.adjacencies = new Edge[]{new Edge(E3, pythagDistance(PLAZ, E3)),
									new Edge(C4, pythagDistance(PLAZ, C4)),
									new Edge(VPLAZ, pythagDistance(PLAZ, VPLAZ)),
									new Edge(U1, pythagDistance(PLAZ, U1)),
									new Edge(LL, pythagDistance(PLAZ, LL)),
									new Edge(AMP, pythagDistance(PLAZ, AMP))};
		LL.adjacencies = new Edge[]{new Edge(VLL, pythagDistance(LL, VLL)),
									new Edge(PLAZ, pythagDistance(LL, PLAZ)),
									new Edge(UU1, pythagDistance(LL, UU1))};
		UU1.adjacencies = new Edge[]{new Edge(LL, pythagDistance(UU1, LL)),
									new Edge(UU2, pythagDistance(UU1, UU2))};
		C4.adjacencies = new Edge[]{new Edge(E2, pythagDistance(C4, E2)),
									new Edge(E3, pythagDistance(C4, E3)),
									new Edge(PLAZ, pythagDistance(C4, PLAZ)),
									new Edge(U1, pythagDistance(C4, U1)),
									new Edge(V2, pythagDistance(C4, V2)),
									new Edge(AMP, pythagDistance(C4, AMP)),
									new Edge(R5, pythagDistance(C4, R5)),};
		U1.adjacencies = new Edge[]{new Edge(UU2, pythagDistance(U1, UU2)),
									new Edge(PLAZ, pythagDistance(U1, PLAZ)),
									new Edge(C4, pythagDistance(U1, C4)),
									new Edge(V2, pythagDistance(U1, V2)),
									new Edge(AMP, pythagDistance(U1, AMP)),
									new Edge(LL, pythagDistance(U1, LL))};
		UU2.adjacencies = new Edge[]{new Edge(VUU, pythagDistance(UU2, VUU)),
									new Edge(UU1, pythagDistance(UU2, UU1)),
									new Edge(U1, pythagDistance(UU2, U1))};
		B1.adjacencies = new Edge[]{new Edge(B2, pythagDistance(B1, B2)),
									new Edge(IT1, pythagDistance(B1, IT1))};
		B2.adjacencies = new Edge[]{new Edge(B1, pythagDistance(B2, B1)),
									new Edge(VR, pythagDistance(B2, VR)),
									new Edge(R1, pythagDistance(B2, R1)),
									new Edge(CC2, pythagDistance(B2, CC2)),
									new Edge(L3, pythagDistance(B2, L3)),
									new Edge(D2, pythagDistance(B2, D2)),
									new Edge(D3, pythagDistance(B2, D3)),
									new Edge(G, pythagDistance(B2, G))};
		G.adjacencies = new Edge[]{	new Edge(B2, pythagDistance(G, B2)),
									new Edge(VG, pythagDistance(G, VG)),
									new Edge(VR, pythagDistance(G, VR)),
									new Edge(CC2, pythagDistance(G, CC2)),
									new Edge(L3, pythagDistance(G, L3)),
									new Edge(D2, pythagDistance(G, D2)),
									new Edge(D3, pythagDistance(G, D3)),
									new Edge(R4, pythagDistance(G, R4)),
									new Edge(Z, pythagDistance(G, Z))};
		R4.adjacencies = new Edge[]{new Edge(VR, pythagDistance(R4, VR)),
									new Edge(G, pythagDistance(R4, G)),
									new Edge(CC2, pythagDistance(R4, CC2)),
									new Edge(L3, pythagDistance(R4, L3)),
									new Edge(D2, pythagDistance(R4, D2)),
									new Edge(D3, pythagDistance(R4, D3)),
									new Edge(VC, pythagDistance(R4, VC)),
									new Edge(R5, pythagDistance(R4, R5)),
									new Edge(C2, pythagDistance(R4, C2)),
									new Edge(C3, pythagDistance(R4, C3)),
									new Edge(C4, pythagDistance(R4, C4)),};
		IT1.adjacencies = new Edge[]{new Edge(VIT, pythagDistance(IT1, VIT)),
									new Edge(B1, pythagDistance(IT1, B1)),
									new Edge(R1, pythagDistance(IT1, R1)),
									new Edge(W1, pythagDistance(IT1, W1)),
									new Edge(IT2, pythagDistance(IT1, IT2))};
		R1.adjacencies = new Edge[]{new Edge(VR, pythagDistance(R1, VR)),
									new Edge(B2, pythagDistance(R1, B2)),
									new Edge(IT1, pythagDistance(R1, IT1)),
									new Edge(IT2, pythagDistance(R1, IT2)),
									new Edge(W1, pythagDistance(R1, W1)),
									new Edge(Z, pythagDistance(R1, Z)),
									new Edge(R3, pythagDistance(R1, R3))};
		Z.adjacencies = new Edge[]{	new Edge(VR, pythagDistance(Z, VR)),
									new Edge(VZ, pythagDistance(Z, VZ)),
									new Edge(R1, pythagDistance(Z, R1)),
									new Edge(R3, pythagDistance(Z, R3)),
									new Edge(LP1, pythagDistance(Z,LP1))};
		R3.adjacencies = new Edge[]{new Edge(VR, pythagDistance(R3, VR)),
									new Edge(Z, pythagDistance(R3, Z)),
									new Edge(LP1, pythagDistance(R3, LP1)),
									new Edge(R5, pythagDistance(R3, R5)),
									new Edge(V1, pythagDistance(R3, V1)),
									new Edge(CA1, pythagDistance(R3, CA1)),
									new Edge(GM1, pythagDistance(R3, GM1))};
		R5.adjacencies = new Edge[]{new Edge(VC, pythagDistance(R5, VC)),
									new Edge(VR, pythagDistance(R5, VR)),
									new Edge(R4, pythagDistance(R5, R4)),
									new Edge(R3, pythagDistance(R5, R3)),
									new Edge(LP1, pythagDistance(R5, LP1)),
									new Edge(LP2, pythagDistance(R5, LP2)),
									new Edge(FC, pythagDistance(R5, FC)),
									new Edge(V1, pythagDistance(R5, V1)),
									new Edge(C5, pythagDistance(R5, C5)),
									new Edge(C2, pythagDistance(R5, C2)),
									new Edge(C3, pythagDistance(R5, C3)),
									new Edge(C4, pythagDistance(R5, C4))};
		C5.adjacencies = new Edge[]{new Edge(VV, pythagDistance(C5, VV)),
									new Edge(R5, pythagDistance(C5, R5)),
									new Edge(V1, pythagDistance(C5, V1)),
									new Edge(C6, pythagDistance(C5, C6))};
		C6.adjacencies = new Edge[]{new Edge(VV, pythagDistance(C6, VV)),
									new Edge(C5, pythagDistance(C6, C5)),
									new Edge(V2, pythagDistance(C6, V2))};
		V2.adjacencies = new Edge[]{new Edge(VV, pythagDistance(V2, VV)),
									new Edge(C6, pythagDistance(V2, C6)),
									new Edge(C4, pythagDistance(V2, C4)),
									new Edge(AMP, pythagDistance(V2, AMP))};
		AMP.adjacencies = new Edge[]{new Edge(VAMP, pythagDistance(AMP, VAMP)),
									new Edge(V2, pythagDistance(AMP, V2)),
									new Edge(C4, pythagDistance(AMP, C4)),
									new Edge(PLAZ, pythagDistance(AMP, PLAZ)),
									new Edge(U1, pythagDistance(AMP, U1)),
									new Edge(U2, pythagDistance(AMP, U2)),
									new Edge(P1, pythagDistance(AMP, P1)),
									new Edge(CA2, pythagDistance(AMP, CA2))};
		W1.adjacencies = new Edge[]{new Edge(VW, pythagDistance(W1, VW)),
									new Edge(IT1, pythagDistance(W1, IT1)),
									new Edge(R1, pythagDistance(W1, E1)),
									new Edge(Z, pythagDistance(W1, Z)),
									new Edge(R3, pythagDistance(W1, R3)),
									new Edge(LP1, pythagDistance(W1, LP1))};
		LP1.adjacencies = new Edge[]{new Edge(VLP, pythagDistance(LP1, VLP)),
									new Edge(W1, pythagDistance(LP1, W1)),
									new Edge(Z, pythagDistance(LP1, Z)),
									new Edge(R3, pythagDistance(LP1, R3)),
									new Edge(R5, pythagDistance(LP1, R5)),
									new Edge(V1, pythagDistance(LP1, V1)),
									new Edge(CA1, pythagDistance(LP1, CA1)),
									new Edge(GM1, pythagDistance(LP1, GM1)),
									new Edge(LP2, pythagDistance(LP1, LP2))};
		V1.adjacencies = new Edge[]{new Edge(VV, pythagDistance(V1, VV)),
									new Edge(C5, pythagDistance(V1, C5)),
									new Edge(R5, pythagDistance(V1, R5)),
									new Edge(R3, pythagDistance(V1, R3)),
									new Edge(LP1, pythagDistance(V1, LP1)),
									new Edge(LP2, pythagDistance(V1, LP2)),
									new Edge(FC, pythagDistance(V1, FC)),
									new Edge(CA1, pythagDistance(V1, CA1))};
		U2.adjacencies = new Edge[]{new Edge(VU, pythagDistance(U2, VU)),
									new Edge(AMP, pythagDistance(U2, AMP)),
									new Edge(CA2, pythagDistance(U2, CA2)),
									new Edge(P1, pythagDistance(U2, P1))};
		IT2.adjacencies = new Edge[]{new Edge(VIT, pythagDistance(IT2, VIT)),
									new Edge(IT1, pythagDistance(IT2, IT1)),
									new Edge(IT3, pythagDistance(IT2, IT3))};
		LP2.adjacencies = new Edge[]{new Edge(VLP, pythagDistance(LP2, VLP)),
									new Edge(LP1, pythagDistance(LP2, LP1)),
									new Edge(R5, pythagDistance(LP2, R5)),
									new Edge(V1, pythagDistance(LP2, V1)),
									new Edge(CA1, pythagDistance(LP2, CA1)),
									new Edge(GM1, pythagDistance(LP2, GM1)),
									new Edge(FC, pythagDistance(LP2, FC))};
		CA1.adjacencies = new Edge[]{new Edge(R3, pythagDistance(CA1, R3)),
									new Edge(LP1, pythagDistance(CA1, LP1)),
									new Edge(LP2, pythagDistance(CA1, LP2)),
									new Edge(FC, pythagDistance(CA1, FC)),
									new Edge(GM1, pythagDistance(CA1, GM1)),
									new Edge(V1, pythagDistance(CA1, V1)),
									new Edge(VCA, pythagDistance(CA1, VCA))};
		IT3.adjacencies = new Edge[]{new Edge(VIT, pythagDistance(IT3, VIT)),
									new Edge(IT2, pythagDistance(IT3, IT2)),
									new Edge(W2, pythagDistance(IT3, W2)),
									new Edge(P, pythagDistance(IT3, P))};
		W2.adjacencies = new Edge[]{new Edge(IT3, pythagDistance(W2, IT3)),
									new Edge(VW, pythagDistance(W2, VW)),
									new Edge(VFS, pythagDistance(W2, VFS)),
									new Edge(FS, pythagDistance(W2, FS)),
									new Edge(P, pythagDistance(W2, P))};
		FS.adjacencies = new Edge[]{new Edge(VFS, pythagDistance(FS, VFS)),
									new Edge(W2, pythagDistance(FS, W2)),
									new Edge(FC, pythagDistance(FS, FC)),
									new Edge(FB, pythagDistance(FS, FB))};
		FC.adjacencies = new Edge[]{new Edge(VFC, pythagDistance(FC, VFC)),
									new Edge(FS, pythagDistance(FC, FS)),
									new Edge(FB, pythagDistance(FC, FB)),
									new Edge(LP2, pythagDistance(FC, LP2)),
									new Edge(R5, pythagDistance(FC, R5)),
									new Edge(V1, pythagDistance(FC, V1)),
									new Edge(CA1, pythagDistance(FC, CA1)),
									new Edge(GM1, pythagDistance(FC, GM1))};
		GM1.adjacencies = new Edge[]{new Edge(VGM, pythagDistance(GM1, VGM)),
									new Edge(FC, pythagDistance(GM1, FC)),
									new Edge(LP2, pythagDistance(GM1, LP2)),
									new Edge(LP1, pythagDistance(GM1, LP1)),
									new Edge(R3, pythagDistance(GM1, R3)),
									new Edge(CA1, pythagDistance(GM1, CA1)),
									new Edge(CA2, pythagDistance(GM1, CA2)),
									new Edge(GM2, pythagDistance(GM1, GM2))};
		CA2.adjacencies = new Edge[]{new Edge(VCA, pythagDistance(CA2, VCA)),
									new Edge(VGM, pythagDistance(CA2, VGM)),
									new Edge(GM1, pythagDistance(CA2, GM1)),
									new Edge(GM2, pythagDistance(CA2, GM2)),
									new Edge(U2, pythagDistance(CA2, U2)),
									new Edge(AMP, pythagDistance(CA2, AMP)),
									new Edge(P1, pythagDistance(CA2, P1))};
		P1.adjacencies = new Edge[]{new Edge(U2, pythagDistance(P1, U2)),
									new Edge(AMP, pythagDistance(P1, AMP)),
									new Edge(CA2, pythagDistance(P1, CA2)),
									new Edge(P2, pythagDistance(P1, P2))};
		P.adjacencies = new Edge[]{new Edge(VP, pythagDistance(P, VP)),
									new Edge(W2, pythagDistance(P, W2)),
									new Edge(O, pythagDistance(P, O)),
									new Edge(VFS, pythagDistance(P, VFS))};
		O.adjacencies = new Edge[]{	new Edge(VO, pythagDistance(O, VP)),
									new Edge(P, pythagDistance(O, P)),
									new Edge(VFS, pythagDistance(O, VFS))};
		FB.adjacencies = new Edge[]{new Edge(FC, pythagDistance(FB, FC)),
									new Edge(FS, pythagDistance(FB, FS)),
									new Edge(VFB, pythagDistance(FB, VFB))};
		GM2.adjacencies = new Edge[]{new Edge(VGM, pythagDistance(GM2, VGM)),
									new Edge(VAN, pythagDistance(GM2, VAN)),
									new Edge(CA2, pythagDistance(GM2, CA2)),
									new Edge(P2, pythagDistance(GM2, P2)),
									new Edge(STAD, pythagDistance(GM2, STAD))};
		P2.adjacencies = new Edge[]{new Edge(P1, pythagDistance(P2, P1)),
									new Edge(GM2, pythagDistance(P2, GM2)),
									new Edge(STAD, pythagDistance(P2, STAD)),
									new Edge(SV, pythagDistance(P2, SV))};
		SV.adjacencies = new Edge[]{new Edge(VSV, pythagDistance(SV, VSV)),
									new Edge(P2, pythagDistance(SV, P2))};
		STAD.adjacencies = new Edge[]{new Edge(VS, pythagDistance(STAD, VS)),
									new Edge(GM2, pythagDistance(STAD, GM2)),
									new Edge(P2, pythagDistance(STAD, P2)),
									new Edge(SV, pythagDistance(STAD, SV))};
		
		/**
		 * Putting all of the now created vertices into an array.
		 */
		Vertex[] vertices = { VHH, VL, VCC, VD, VIT, VB, VC, VG, VR, VZ, VE, VLL, VU, VUU, VW, VLP, VP, VO, VFS, VFB, VFC, VGM, VCA, VV, VSV, VAMP, VPLAZ, VAN, VS,
				L1, HH, L2, CC1, D1, D4, E1, CC2, L3, D2, D3, C1, C2, C3, E2, E3, PLAZ, LL, UU1, C4, U1, UU2, B1, B2, G, R4, IT1, R1, Z, R3, R5,
				C5, C6, V2, AMP, W1, LP1, V1, U2, IT2, LP2, CA1, IT3, W2, FS, FC, GM1, CA2, P1, P, O, FB, GM2, P2, SV, STAD};
		
    	return vertices;
    }
}