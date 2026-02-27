package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "ProdutoLista.jsp";

        if (acao == null) acao = "listar";

        try {
            if ("listar".equals(acao)) {
                List<Produto> produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
            } else if ("formIncluir".equals(acao)) {
                destino = "ProdutoDados.jsp";
            } else if ("formAlterar".equals(acao)) {
                request.setAttribute("produto", facade.find(Integer.parseInt(request.getParameter("id"))));
                destino = "ProdutoDados.jsp";
            } else if ("incluir".equals(acao)) {
                Produto pInc = new Produto();
                pInc.setNome(request.getParameter("nome"));
                pInc.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                pInc.setPrecoVenda(Float.parseFloat(request.getParameter("preco")));
                facade.create(pInc);
                request.setAttribute("produtos", facade.findAll());
            } else if ("alterar".equals(acao)) {
                Produto pAlt = facade.find(Integer.parseInt(request.getParameter("id")));
                pAlt.setNome(request.getParameter("nome"));
                pAlt.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                pAlt.setPrecoVenda(Float.parseFloat(request.getParameter("preco")));
                facade.edit(pAlt);
                request.setAttribute("produtos", facade.findAll());
            } else if ("excluir".equals(acao)) {
                facade.remove(facade.find(Integer.parseInt(request.getParameter("id"))));
                request.setAttribute("produtos", facade.findAll());
            }
        } catch (Exception e) {
             request.setAttribute("produtos", facade.findAll());
        }

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { processRequest(req, resp); }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { processRequest(req, resp); }
}