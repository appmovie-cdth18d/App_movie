<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="{{ URL::to('index') }}" class="brand-link">
      <img src="{{ asset('public/dist/img/AdminLTELogo.png')}}" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">T-Cinema</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="{{ asset('public/dist/img/user2-160x160.jpg')}}" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Võ Thanh Tấn</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview">
            <a href="{{ URL::to('index') }}" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Trang Tổng Quan
              </p>
            </a>
          </li>
          
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="{{ URL::to('taikhoan/data_taikhoan')}}" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Thông Tin Khách Hàng
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('taikhoan/data_taikhoan')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('taikhoan/them_taikhoan') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('taikhoan/sua_taikhoan') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>
            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-phim-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Phim
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('phim/data_phim')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('phim/them_phim') }}" class="nav-link">
                  <p>Thêm</p>
                </a>
              </li>
            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-rap-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Rap
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_rap')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_rap') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_rap') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-lich-chiueu-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Lịch Chiếu
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_lichchieu')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_lichchieu') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_lichchieu') }}" class="nav-link">
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Tài Khoản
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_taikhoan')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_taikhoan') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_taikhoan') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Vé
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_ve')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_ve') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_ve') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Thể Loại Phim
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('theloaiphim/data_theloaiphim')}}" class="nav-link">
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('theloaiphim/them_theloaiphim') }}" class="nav-link">   
                  <p>Thêm</p>
                </a>
              </li>
            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Ghế
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_ghe')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_ghe') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_ghe') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Danh Sách Vé
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_dsve')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_dsve') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_dsve') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Thông Tin Bình Luận
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('binhluan/data_binhluan')}}" class="nav-link">
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Loại Ghế
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_loaighe')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_loaighe') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_loaighe') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Giá
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('gia/data_gia')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('gia/them_gia') }}" class="nav-link">    
                  <p>Thêm</p>
                </a>
              </li>
            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Định Dạng Phim
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('dinhdangphim/data_dinhdangphim')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('dinhdangphim/them_dinhdangphim') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Trạng Thái Phim
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('trangthaiphim/data_trangthaiphim')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('trangthaiphim/them_trangthaiphim') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
          <!--tables-thong-tin-khach-hang-->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Suất Chiếu
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href=" {{ URL::to('data_suatchieu')}}" class="nav-link">
                  
                  <p>Dữ Liệu Bảng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('them_suatchieu') }}" class="nav-link">
                  
                  <p>Thêm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="{{ URL::to('sua_suatchieu') }}" class="nav-link">
                  
                  <p>Sửa</p>
                </a>
              </li>

            </ul>
          </li>
          <!--endtables-->
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>