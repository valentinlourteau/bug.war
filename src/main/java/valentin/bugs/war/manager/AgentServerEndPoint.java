//package valentin.bugs.war.manager;
//
//import java.io.IOException;
//import java.io.Serializable;
//
//import javax.enterprise.context.SessionScoped;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//
//import valentin.bugs.war.agent.AgentRequest;
//import valentin.bugs.war.agent.AgentRequestTypeEnum;
//
//@ServerEndpoint("/agentServerEndPoint")
//public class AgentServerEndPoint implements Serializable {
//
//	/**
//	 * @OnOpen allows us to intercept the creation of a new session. The session
//	 *         class allows us to send data to the user. In the method onOpen,
//	 *         we'll let the user know that the handshake was successful.
//	 */
//	@OnOpen
//	public void onOpen(Session session) {
//		System.out.println(session.getId() + " has opened a connection");
//		try {
//			session.getBasicRemote().sendText("Connection Established");
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	/**
//	 * Un agent demande quelque chose.
//	 */
//	@OnMessage
//	public void onMessage(Object message, Session session) {
//		if (message instanceof AgentRequest) {
//			if (((AgentRequest) message).getAgentRequestType().equals(AgentRequestTypeEnum.PERCEIVE))
//				((AgentRequest) message).getAgent().setPerceptedElements(perceptedElements);
//		}
//	}
//
//	/**
//	 * The user closes the connection.
//	 * 
//	 * Note: you can't send messages to the client from this method
//	 */
//	@OnClose
//	public void onClose(Session session) {
//		System.out.println("Session " + session.getId() + " has ended");
//	}
//
//}
