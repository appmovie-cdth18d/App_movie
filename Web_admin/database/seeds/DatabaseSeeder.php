<?php

use Illuminate\Database\Seeder;
class DatabaseSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $this->call(TheLoaiPhimDatabaseSeeder::class);
        $this->call(TrangThaiPhimDatabaseSeeder::class);
        $this->call(GiaDatabaseSeeder::class);
        $this->call(DinhDangPhimDatabaseSeeder::class);
        $this->call(RapDatabaseSeeder::class);
        $this->call(LoaiGheDatabaseSeeder::class);
        $this->call(GheDatabaseSeeder::class);

        $this->call(RapDatabaseSeeder::class);
        $this->call(LoaiGheDatabaseSeeder::class);
        $this->call(GheDatabaseSeeder::class);

        $this->call(PhimDatabaseSeeder::class);
        $this->call(TaikhoanDatabaseSeeder::class);
        $this->call(BinhluanDatabaseSeeder::class);
        $this->call(PhanhoiDatabaseSeeder::class);
        $this->call(LichchieuDatabaseSeeder::class);
        $this->call(SuatChieuDatabaseSeeder::class);
        $this->call(DanhsachVeDatabaseSeeder::class);
        $this->call(VeDatabaseSeeder::class);
    }
}

class DaoDienDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('daodien')->insert([
			['Tendaodien'=>'Victor Vũ','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendaodien'=>'Trần Anh Hùng','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendaodien'=>'Vũ Ngọc Đăng','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendaodien'=>'Nguyễn Quang Dũng','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendaodien'=>'Charlie Nguyễn','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam']
		]);
	}
}
class DienVienDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('dienvien')->insert([
			['Tendienvien'=>'Nguyễn Văn A','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendienvien'=>'Nguyễn Văn B','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendienvien'=>'Nguyễn Văn C','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendienvien'=>'Nguyễn Văn D','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam'],
			['Tendienvien'=>'Nguyễn Văn E','Ngaysinh'=>'1975-25-11','Gioitinh'=>'Nam']
		]);
	}
}
class DS_DienVienDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('ds_dienvien')->insert([
			['dienvien_id'=>'1','phim_id'=>'1',],
			['dienvien_id'=>'2','phim_id'=>'1',],
			['dienvien_id'=>'3','phim_id'=>'2',],
			['dienvien_id'=>'4','phim_id'=>'2',],
			['dienvien_id'=>'1','phim_id'=>'3',],
			['dienvien_id'=>'3','phim_id'=>'3',],
			['dienvien_id'=>'2','phim_id'=>'4',],
			['dienvien_id'=>'4','phim_id'=>'4',],
			['dienvien_id'=>'3','phim_id'=>'5',],
			['dienvien_id'=>'5','phim_id'=>'5',]
		]);
	}
}
class TheLoaiPhimDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('TheLoaiPhim')->insert([
			['Tentheloai'=>'Kinh dị'],
			['Tentheloai'=>'Hành Động'],
			['Tentheloai'=>'Hài hước'],
			['Tentheloai'=>'Võ Thuật'],
			['Tentheloai'=>'Tình cảm'],
			['Tentheloai'=>'Viễn tưởng'],
			['Tentheloai'=>'Hoạt hình'],
			['Tentheloai'=>'Chiến trang'],
			['Tentheloai'=>'Tâm lý']
		]);
	}
}
class TrangThaiPhimDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('TrangThaiPhim')->insert([
			['Tentrangthai'=>'Phim sắp chiếu'],
			['Tentrangthai'=>'Phim đang chiếu'],
			['Tentrangthai'=>'Phim ngừng chiếu']
		]);
	}
}
class GiaDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('gia')->insert([
			['giatien'=>'20000'],
			['giatien'=>'30000'],
			['giatien'=>'40000'],
		]);
	}
}
class DinhDangPhimDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('DinhDangPhim')->insert([
			['Loaidinhdang'=>'2D','Gia_id'=>'1'],
			['Loaidinhdang'=>'3D','Gia_id'=>'2'],
			['Loaidinhdang'=>'4D','Gia_id'=>'3']
		]);
	}
}
class RapDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('rap')->insert([
			['Tenrap'=>'A1','hang'=>'6','cot'=>'5','chinhanh'=>'CGV Vincom Thủ Đức'],
			['Tenrap'=>'B1','hang'=>'6','cot'=>'5','chinhanh'=>'CGV Vincom Thủ Đức']
		]);
	}
}
class LoaiGheDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('loaighe')->insert([
			['Tenloaighe'=>'thường','gia_id'=>'1'],
			['Tenloaighe'=>'trung bình','gia_id'=>'2'],
			['Tenloaighe'=>'VIP','gia_id'=>'3']
		]);
	}
}
class GheDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('ghe')->insert([
			['Soghe'=>'01','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'02','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'03','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'04','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'05','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'06','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'07','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'08','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'09','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'10','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'11','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'12','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'13','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'14','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'15','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'16','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'17','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'18','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'19','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'20','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'21','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'22','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'23','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'24','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'25','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'26','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'27','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'28','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'29','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],
			['Soghe'=>'30','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'1'],

			['Soghe'=>'01','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'02','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'03','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'04','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'05','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'06','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'07','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'08','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'09','Loaighe_id'=>'1','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'10','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'11','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'12','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'13','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'14','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'15','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'16','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'17','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'18','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'19','Loaighe_id'=>'2','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'20','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'21','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'22','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'23','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'24','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'25','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'26','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'27','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'28','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'29','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2'],
			['Soghe'=>'30','Loaighe_id'=>'3','Trangthai'=>'0','rap_id'=>'2']

		]);
	}
}
class PhimDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('phim')->insert([
			['Tenphim'=>'aaaaaaa', 'Hinhanh'=>'dwdwvve','Diem'=>'7','Mota'=>'aaaa','Trailer'=>'aaaaa','ThoiLuong'=>'45:00','dinhdang_id'=>'1', 'daodien_id'=>'1','trangthai_id'=>'1','theloai_id'=>'1'],
			['Tenphim'=>'bbbbb', 'Hinhanh'=>'cdcveeewc','Diem'=>'7','Mota'=>'aaaa','Trailer'=>'aaaaa','ThoiLuong'=>'45:00','dinhdang_id'=>'1','daodien_id'=>'2','trangthai_id'=>'1','theloai_id'=>'1'],
			['Tenphim'=>'ccccc', 'Hinhanh'=>'cdcewd','Diem'=>'7','Mota'=>'aaaa','Trailer'=>'aaaaa','ThoiLuong'=>'45:00','dinhdang_id'=>'1','daodien_id'=>'3','trangthai_id'=>'2','theloai_id'=>'1'],
			['Tenphim'=>'dddddd', 'Hinhanh'=>'vdvv','Diem'=>'7','Mota'=>'aaaa','Trailer'=>'aaaaa','ThoiLuong'=>'45:00','dinhdang_id'=>'1','daodien_id'=>'4','trangthai_id'=>'1','theloai_id'=>'1'],
			['Tenphim'=>'eeeee', 'Hinhanh'=>'fewfwf','Diem'=>'7','Mota'=>'aaaa','Trailer'=>'aaaaa','ThoiLuong'=>'45:00','dinhdang_id'=>'1','daodien_id'=>'5','trangthai_id'=>'2','theloai_id'=>'1']
		]);
	}
}
class TaikhoanDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('taikhoan')->insert([
			['HoTen'=>'Nguyễn Thành Tâm','Ten_TK'=>'admin','matkhau'=>'123','Email'=>'admin@gmail.com','Ngaysinh'=>'2000-02-19','Phai'=>'nam','SDT'=>'0123456789','Diachi'=>'null'],
			['HoTen'=>'Võ Thanh Tấn','Ten_TK'=>'tan','matkhau'=>'123','Email'=>'tan@gmail.com','Ngaysinh'=>'2000-02-19','Phai'=>'nam','SDT'=>'1536823460','Diachi'=>'null'],
			['HoTen'=>'Cao Minh Thông','Ten_TK'=>'thong','matkhau'=>'123','Email'=>'thong@gmail.com','Ngaysinh'=>'2000-02-19','Phai'=>'nam','SDT'=>'1425783590','Diachi'=>'null']
		]);
	}
}
class BinhluanDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('binhluan')->insert([
			['Noidung'=>'phim hay', 'Ngaydang'=>'2000-11-25','taikhoan_id'=>'2','phim_id'=>'1'],
			['Noidung'=>'phim dở', 'Ngaydang'=>'2000-11-25','taikhoan_id'=>'2','phim_id'=>'1'],
			['Noidung'=>'phim chán', 'Ngaydang'=>'2000-11-25','taikhoan_id'=>'2','phim_id'=>'1']
		]);
	}
}
class PhanhoiDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('phanhoi')->insert([
			['Noidung'=>'phim hay', 'Ngaydang'=>'2000-11-25','taikhoan_id'=>'3','binhluan_id'=>'1'],
			['Noidung'=>'phim dở', 'Ngaydang'=>'2000-11-25','taikhoan_id'=>'3','binhluan_id'=>'2'],
			['Noidung'=>'phim chán', 'Ngaydang'=>'2000-11-25','taikhoan_id'=>'3','binhluan_id'=>'3']
		]);
	}
}
class LichchieuDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('lichchieu')->insert([
			['phim_id'=>'1','rap_id'=>'1','thgian_batdau'=>'2020-11-20','thgian_ketthuc'=>'2020-11-20'],
			['phim_id'=>'2','rap_id'=>'1','thgian_batdau'=>'2020-11-20','thgian_ketthuc'=>'2020-11-20'],
			['phim_id'=>'3','rap_id'=>'1','thgian_batdau'=>'2020-11-20','thgian_ketthuc'=>'2020-11-20'],
			['phim_id'=>'1','rap_id'=>'2','thgian_batdau'=>'2020-11-20','thgian_ketthuc'=>'2020-11-20'],
			['phim_id'=>'2','rap_id'=>'2','thgian_batdau'=>'2020-11-20','thgian_ketthuc'=>'2020-11-20'],
			['phim_id'=>'3','rap_id'=>'2','thgian_batdau'=>'2020-11-20','thgian_ketthuc'=>'2020-11-20']
		]);
	}
}
class SuatChieuDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('suatchieu')->insert([
			['GioChieu'=>'09:00:00','phim_id'=>'1', 'lichchieu_id'=>'1'],
			['GioChieu'=>'11:00:00','phim_id'=>'2', 'lichchieu_id'=>'2'],
			['GioChieu'=>'13:00:00','phim_id'=>'3', 'lichchieu_id'=>'3'],
			['GioChieu'=>'09:00:00','phim_id'=>'1', 'lichchieu_id'=>'4'],
			['GioChieu'=>'11:00:00','phim_id'=>'2', 'lichchieu_id'=>'5'],
			['GioChieu'=>'13:00:00','phim_id'=>'3', 'lichchieu_id'=>'6']
		]);
	}
}
class DanhsachVeDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('danhsachve')->insert([
			['Soluong'=>'1','Tongtien'=>'40000','taikhoan_id'=>'2'],
			['Soluong'=>'2','Tongtien'=>'80000','taikhoan_id'=>'3']	
		]);
	}
}
class VeDatabaseSeeder extends Seeder
{
	public function run() {
		DB::table('ve')->insert([
			['dsve_id'=>'1','lichchieu_id'=>'1','Thanhtien'=>'40000'],
			['dsve_id'=>'2','lichchieu_id'=>'2','Thanhtien'=>'40000'],
			['dsve_id'=>'2','lichchieu_id'=>'2','Thanhtien'=>'40000'],
		]);
	}
}

