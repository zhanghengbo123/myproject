package core.admin.util;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public class PDFUtils {/*
    private static final Logger logger = Logger.getLogger(PDFUtils.class);

    // 数据表字段数
    private static final int colNumber = 2;

    // 表格的设置
    private static final int padding = 2;

    // 导出Pdf文挡
    public static void exportPdfDocument(PayPdfEntity payPdfEntity,HttpServletResponse response) {
        // 创建文Pdf文挡50, 50, 50,50左右上下距离
        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50,
                50);
        PdfWriter pdfWriter = null;
        OutputStream bos = null;
        try {
            //使用PDFWriter进行写文件操作
          bos = new BufferedOutputStream(response.getOutputStream());
            pdfWriter = PdfWriter.getInstance(document,bos);
            document.open();
            // 中文字体
            BaseFont bfChinese =BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            Font fontChinese = new Font(bfChinese, 18, Font.NORMAL);
            // 创建有colNumber(2)列的表格
            PdfPTable datatable = new PdfPTable(colNumber);
            //定义表格的宽度
            int[] cellsWidth = { 20, 60 };
            datatable.setWidths(cellsWidth);
            // 表格的宽度百分比
            datatable.setWidthPercentage(60);
            //datatable.addCell("山东三四物流服务有限公司");
            datatable.getDefaultCell().setPadding(padding);
            datatable.getDefaultCell().setBorderWidth(1);

            //设置表格的底色
            datatable.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            datatable.getDefaultCell().setHorizontalAlignment(
                    Element.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell(new Paragraph("三四物流付款单单据", fontChinese));

            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(2);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            datatable.addCell(cell);
            if (!StringUtils.isEmpty(payPdfEntity.getPdfCode())) {
                datatable.addCell(new Paragraph("运输单号", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfCode(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getShipperName())) {
                datatable.addCell(new Paragraph("发运厂家", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getShipperName(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getShipperAddress())) {
                datatable.addCell(new Paragraph("运输起点", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getShipperAddress(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getConsigneeAddress())) {
                datatable.addCell(new Paragraph("运输终点", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getConsigneeAddress(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getGoodsWeight())) {
                datatable.addCell(new Paragraph("运输吨位", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getGoodsWeight()+"（吨）", fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getCoast().toString())) {
                datatable.addCell(new Paragraph("运输成本", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getCoast()+"（元）", fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfPayMoney())) {
                datatable.addCell(new Paragraph("付款金额", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfPayMoney()+"（元）", fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfPayType())) {
                datatable.addCell(new Paragraph("付款方式", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfPayType(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfApplyName())) {
                datatable.addCell(new Paragraph("申请人", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfApplyName(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfReason())) {
                datatable.addCell(new Paragraph("付款事由", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfReason(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }


            if (payPdfEntity.getPdfPayTime()!= null && payPdfEntity.getPdfPayTime() > 0) {
                datatable.addCell(new Paragraph("支付日期", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(DateFormat.formatDate(payPdfEntity.getPdfPayTime()), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfPayToName())) {
                datatable.addCell(new Paragraph("支付对象", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfPayToName(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfPayToBank())) {
                datatable.addCell(new Paragraph("开户银行", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfPayToBank(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            if (!StringUtils.isEmpty(payPdfEntity.getPdfPayToBankNo())) {
                datatable.addCell(new Paragraph("银行账户", fontChinese));
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntity.getPdfPayToBankNo(), fontChinese));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable.addCell(pdfPCell);
            }
            java.util.List<PayMessage> payPdfEntities = payPdfEntity.getPdfPayMessageEntities();
            if (payPdfEntities != null && payPdfEntities.size() > 0) {
                PdfPCell pCell = new PdfPCell(new Paragraph("审批人", fontChinese));
                pCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pCell.setRowspan(payPdfEntities.size());
                datatable.addCell(pCell);
                for (int i = 0; i < payPdfEntities.size(); i++) {
                    PdfPCell pdfPCell = new PdfPCell(new Paragraph(payPdfEntities.get(i).getUserName()+":"+payPdfEntities.get(i).getMessage() + "   (" + DateFormat.formatDate(payPdfEntities.get(i).getCreateTime()) + ")", fontChinese));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    datatable.addCell(pdfPCell);
                }
            } else {
                PdfPCell pCell = new PdfPCell(new Paragraph("审批人", fontChinese));
                pCell.setRowspan(1);
                datatable.addCell(pCell);
                datatable.addCell(new Paragraph("无", fontChinese));
            }

            document.add(datatable);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           try{ if (document != null) {
                document.close();
            }
            if (pdfWriter != null) {
                pdfWriter.flush();
                pdfWriter.close();
            }
            if (bos != null) {
                bos.flush();
                bos.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        }
    }*/

    }
