package com.example.computer_managerment.controller;

import com.example.computer_managerment.dao.*;
import com.example.computer_managerment.model.Category;
import com.example.computer_managerment.model.Country;
import com.example.computer_managerment.model.Product;

import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ProductsServlet", urlPatterns = {"/product", ""})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProductsServlet extends HttpServlet {
    private IAccountDAO iAccountDAO;
    private IProductDAO iProductDAO;
    private ICountryDAO iCountryDAO;
    private ICategoryDAO iCategoryDAO;
    private String errors = null;
    List<Category> listCategory;

    @Override
    public void init() throws ServletException {
        iAccountDAO = new AccountDAO();
        iCountryDAO = new CountryDAO();
        iProductDAO = new ProductDAO();
        iCategoryDAO = new CategoryDAO();
        List<Category> listCategory = iCategoryDAO.selectAllCategory();
        List<Country> listCountry = iCountryDAO.selectAllCountry();

        if (this.getServletContext().getAttribute("listCountry") == null) {
            this.getServletContext().setAttribute("listCountry", listCountry);
        }

        if (this.getServletContext().getAttribute("listCategory") == null) {
            this.getServletContext().setAttribute("listCategory", listCategory);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    showDeleteForm(req, resp);
                    break;
                case "login":
                    showLogin(req, resp);
                    break;
                default:
                    try {
                        listProductPaging(req, resp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
            }
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private void listProductPaging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int page = 1;
        int recordsPerPage = 6;
        String search = "";
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (req.getParameter("search") != null) {
            search = req.getParameter("search");
        }
        List<Product> listProduct = iProductDAO.selectAllProductPagingFilter((page - 1) * recordsPerPage, recordsPerPage, search);
        int noOfRecords = iProductDAO.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        listCategory = iCategoryDAO.selectAllCategory();
        req.setAttribute("listProduct", listProduct);
        req.setAttribute("listCategory", listCategory);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);
        req.setAttribute("search", search);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/product/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/account/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        iProductDAO.deleteProducts(id);
        resp.sendRedirect("/product");
    }

//    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Product> listProduct = this.iProductDAO.selectAllProducts();
//        listCategory = this.iCategoryDAO.selectAllCategory();
//        req.setAttribute("listProduct", listProduct);
//        req.setAttribute("listCategory", listCategory);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/product/index.jsp");
//        requestDispatcher.forward(req, resp);
//    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher requestDispatcher;
        Product product = iProductDAO.selectProducts(id);
        req.setAttribute("product", product);
        requestDispatcher = req.getRequestDispatcher("/WEB-INF/product/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(req, resp);
                    break;
                case "edit":
                    updateProduct(req, resp);
                    break;
                default:
//                    listProductPaging(req, resp);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        listCategory = this.iCategoryDAO.selectAllCategory();
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.iProductDAO.selectProducts(id);
        if (product == null) {
            requestDispatcher = req.getRequestDispatcher("/");
        } else {
            String title = req.getParameter("title");
            product.setTitle(title);
            double price = Double.parseDouble(req.getParameter("price"));
            product.setPrice(price);
            String image = req.getParameter("file");
            product.setImage(image);
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            product.setQuantity(quantity);
            String description = req.getParameter("description");
            product.setDescription(description);
            int idCategory = Integer.parseInt(req.getParameter("idcategory"));
            product.setIdCategory(idCategory);

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
            if (!constraintViolations.isEmpty()) {
                for (ConstraintViolation<Product> item : constraintViolations) {
                    errors.add(item.getMessage());
                }
                req.setAttribute("errors", errors);
                req.setAttribute("listCategory", listCategory);
            } else {
                if (iCategoryDAO.selectByIdCategory(idCategory) != null) {
                    for (Part part : req.getParts()) {
                        System.out.println("Content type of Part" + part.getContentType());
                        System.out.println("Name of Part" + part.getName());
                        if (part.getName().equals("file")) {
                            String fileName = extractFileName(part);
                            if (fileName != null && !fileName.isEmpty()) {
                                fileName = new File(fileName).getName();
                                part.write("C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Modul2\\Computer_Managerment\\src\\main\\webapp\\image-load/" + fileName);
                                String servletRealPath = this.getServletContext().getRealPath("/") + "image\\" + fileName;
                                part.write(servletRealPath);
                                product.setImage("image/" + fileName);
                                part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                            }
                        }
                    }
                    iProductDAO.updateProducts(product);
                    req.setAttribute("listCategory", listCategory);
                } else {
                    errors.add("Product type is not available");
                    req.setAttribute("errors", errors);
                    req.setAttribute("listCategory", listCategory);
                }
            }
        }
        requestDispatcher = req.getRequestDispatcher("/WEB-INF/product/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
        System.out.println(System.getProperty("user.home") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        Product product = new Product();
        listCategory = this.iCategoryDAO.selectAllCategory();
        String title = req.getParameter("title");
        product.setTitle(title);
        double price = Double.parseDouble(req.getParameter("price"));
        product.setPrice(price);
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        product.setQuantity(quantity);
        String description = req.getParameter("description");
        product.setDescription(description);
        int category = Integer.parseInt(req.getParameter("idcategory"));
        product.setIdCategory(category);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<Product> item : constraintViolations) {
                errors.add(item.getMessage());
            }
            req.setAttribute("errors", errors);
            req.setAttribute("listCategory", listCategory);
        } else {
            if (iCategoryDAO.selectByIdCategory(category) != null) {
                for (Part part : req.getParts()) {
                    System.out.println("Content type of Part" + part.getContentType());
                    System.out.println("Name of Part" + part.getName());
                    if (part.getName().equals("file")) {
                        String fileName = extractFileName(part);
                        if (fileName != null && !fileName.isEmpty()) {
                            fileName = new File(fileName).getName();
                            part.write("C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Modul2\\Computer_Managerment\\src\\main\\webapp\\image-load\\" + fileName);
                            String servletRealPath = this.getServletContext().getRealPath("/") + "image-load\\" + fileName;
                            part.write(servletRealPath);
                            product.setImage("image-load\\" + fileName);
                            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                        } else {
                            product.setImage(null);
                        }
                    }
                }
                iProductDAO.insertProducts(product);
                req.setAttribute("listCategory", listCategory);
            } else {
                errors.add("Product type is not available");
                req.setAttribute("errors", errors);
                req.setAttribute("listCategory", listCategory);
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/product/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listCategory = this.iCategoryDAO.selectAllCategory();
        req.setAttribute("listCategory", listCategory);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/product/create.jsp");
        requestDispatcher.forward(req, resp);
    }
}
