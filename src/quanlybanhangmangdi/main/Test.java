package quanlybanhangmangdi.main;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import quanlybanhangmangdi.controller.AddBillController;
import quanlybanhangmangdi.controller.EditBillController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyAppController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyBaoCaoController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyDonHangController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyMenuController;
import quanlybanhangmangdi.controller.GiaoDienQuanLyNhanVienController;
import quanlybanhangmangdi.controller.LoginController;
import quanlybanhangmangdi.controller.MenuQuanLyController;
import quanlybanhangmangdi.database.DataHelper;
import quanlybanhangmangdi.model.NhanVien;

public class Test extends Application{
	public static NhanVien nhanVien;
	public static int sttDonHang;

	public static void setLabelThongTinDangNhap(Label UserIDLabel, Label UserNameLabel, Label UserPermissionLabel) throws SQLException {
		UserIDLabel.setText(Test.nhanVien.getTaiKhoan());
		UserNameLabel.setText(Test.nhanVien.getHoTen());
		
		String sql = "SELECT ten FROM chucvu WHERE ma = " + "\"" + Test.nhanVien.getMaChucVu() + "\"";
		ResultSet rs = DataHelper.execQuery(sql);
		
		while(rs.next()) {
			UserPermissionLabel.setText(rs.getString("ten"));
		}
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		showAddBill();
	}
	
	private void showLogin() throws IOException {
		LoginController login = new LoginController();
		login.show();
	}
	
	private void showMenuQuanLy() throws IOException {
		MenuQuanLyController menuQuanLyController = new MenuQuanLyController();
		menuQuanLyController.show();
	}
	
	private void showGiaoDienQuanLy() throws IOException {
		GiaoDienQuanLyDonHangController giaoDienQuanLy = new GiaoDienQuanLyDonHangController();
		giaoDienQuanLy.show();
	}
	
	private void showAddBill() throws IOException {
		AddBillController addBill = new AddBillController();
		addBill.show();
	}
	
	private void showEditBill() throws IOException {
		EditBillController editBill = new EditBillController();
		editBill.show();
	}
}