package com.demo.common.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements
        ServletRequestAware {

    private static final long serialVersionUID = 1L;
    private File userImage;
    private String userImageContentType;
    private String userImageFileName;
    private String filePath;

    private HttpServletRequest servletRequest;

    @Override
    public String execute() throws Exception {
        filePath = servletRequest.getSession().getServletContext().getRealPath("/").concat("userimages");

        // see the server console for actual location
        System.out.println("Image Location:" + filePath);
        File fileToCreate = new File(filePath, this.userImageFileName);
        // copying image in the new file
        FileUtils.copyFile(this.userImage, fileToCreate);

        return SUCCESS;
    }

    public String display() {
        return NONE;
    }

    /**
     * @return the userImage
     */
    public File getUserImage() {
        return userImage;
    }

    /**
     * @param userImage
     *            the userImage to set
     */
    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    /**
     * @return the userImageContentType
     */
    public String getUserImageContentType() {
        return userImageContentType;
    }

    /**
     * @param userImageContentType
     *            the userImageContentType to set
     */
    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    /**
     * @return the userImageFileName
     */
    public String getUserImageFileName() {
        return userImageFileName;
    }

    /**
     * @param userImageFileName
     *            the userImageFileName to set
     */
    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    /**
     * @return the servletRequest
     */
    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    /**
     * @param servletRequest
     *            the servletRequest to set
     */
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
