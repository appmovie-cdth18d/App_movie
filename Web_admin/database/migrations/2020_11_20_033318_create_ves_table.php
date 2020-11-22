<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateVesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ve', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('dsve_id')->unsigned()->index();
            $table->integer('lichchieu_id')->unsigned()->index();
            $table->double('Thanhtien')->defalt(0);
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('lichchieu_id')->references('id')->on('lichchieu');
            $table->foreign('dsve_id')->references('id')->on('danhsachve');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ve');
    }
}
